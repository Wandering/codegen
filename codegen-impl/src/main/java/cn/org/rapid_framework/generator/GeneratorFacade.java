package cn.org.rapid_framework.generator;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.org.rapid_framework.generator.Generator.GeneratorModel;
import cn.org.rapid_framework.generator.provider.db.sql.model.Sql;
import cn.org.rapid_framework.generator.provider.db.table.TableFactory;
import cn.org.rapid_framework.generator.provider.db.table.model.Table;
import cn.org.rapid_framework.generator.provider.db.table.model.util.NumGen;
import cn.org.rapid_framework.generator.provider.java.model.JavaClass;
import cn.org.rapid_framework.generator.provider.page.Action;
import cn.org.rapid_framework.generator.util.BeanHelper;
import cn.org.rapid_framework.generator.util.GLogger;
import cn.org.rapid_framework.generator.util.GeneratorException;
import cn.thinkjoy.codegen.*;
import cn.thinkjoy.codegen.GeneratorMain;

/**
 * 
 * @author badqiu
 *
 */
public class GeneratorFacade {

    private static String[] alreadyTbls = new String[]{
			"_data_model", "_model", "_resource", "_resource_action", "_resource_grid",
			"_role", "_role_resource", "_role_user", "_user_data", "_datagroup", "_datagroup_data", "_user_datagroup"};


	public Generator g = new Generator();
	public GeneratorFacade(){
		g.setOutRootDir(GeneratorProperties.getProperty("outRoot"));
	}

	public static void printAllTableNames() throws Exception {
		PrintUtils.printAllTableNames(TableFactory.getInstance().getAllTables());
	}

	public void deleteOutRootDir() throws IOException {
		g.deleteOutRootDir();
	}

	public void generateByMap(Map map,String templateRootDir) throws Exception {
		new ProcessUtils().processByMap(map, templateRootDir,false);
	}

	public void deleteByMap(Map map,String templateRootDir) throws Exception {
		new ProcessUtils().processByMap(map, templateRootDir,true);
	}

	public void generateByAllTable(String templateRootDir) throws Exception {
		new ProcessUtils().processByAllTable(templateRootDir,false);
	}

    public void generateByTableList(String templateRootDir) throws Exception {
        new ProcessUtils().processByTableList(templateRootDir,false);
    }

	public void deleteByAllTable(String templateRootDir) throws Exception {
		new ProcessUtils().processByAllTable(templateRootDir,true);
	}

    public void generateByTable(String tableName,String templateRootDir) throws Exception {
    	new ProcessUtils().processByTable(tableName,templateRootDir,false);
	}

    public void deleteByTable(String tableName,String templateRootDir) throws Exception {
    	new ProcessUtils().processByTable(tableName,templateRootDir,true);
	}

	public void generateByClass(Class clazz,String templateRootDir) throws Exception {
		new ProcessUtils().processByClass(clazz, templateRootDir,false);
	}

	public void deleteByClass(Class clazz,String templateRootDir) throws Exception {
		new ProcessUtils().processByClass(clazz, templateRootDir,true);
	}

	public void generateBySql(Sql sql,String templateRootDir) throws Exception {
		new ProcessUtils().processBySql(sql,templateRootDir,false);
	}

	public void deleteBySql(Sql sql,String templateRootDir) throws Exception {
		new ProcessUtils().processBySql(sql,templateRootDir,true);
	}

    private Generator getGenerator(String templateRootDir) {
        g.setTemplateRootDir(new File(templateRootDir).getAbsoluteFile());
        return g;
    }

    /** 生成器的上下文，存放的变量将可以在模板中引用 */
    public static class GeneratorContext {
        static ThreadLocal<Map> context = new ThreadLocal<Map>();
        public static void clear() {
            Map m = context.get();
            if(m != null) m.clear();
        }
        public static Map getContext() {
            Map map = context.get();
            if(map == null) {
                setContext(new HashMap());
            }
            return context.get();
        }
        public static void setContext(Map map) {
            context.set(map);
        }
        public static void put(String key,Object value) {
            getContext().put(key, value);
        }
    }

    public class ProcessUtils {

    	public void processByMap(Map params, String templateRootDir,boolean isDelete) throws Exception, FileNotFoundException {
			Generator g = getGenerator(templateRootDir);
			GeneratorModel m = GeneratorModelUtils.newFromMap(params);
			processByGeneratorModel(templateRootDir, isDelete, g, m);
    	}

    	public void processBySql(Sql sql,String templateRootDir,boolean isDelete) throws Exception {
    		Generator g = getGenerator(templateRootDir);
    		GeneratorModel m = GeneratorModelUtils.newFromSql(sql);
    		PrintUtils.printBeginProcess("sql:"+sql.getSourceSql(),isDelete);
    		processByGeneratorModel(templateRootDir,isDelete,g,m);
    	}

    	public void processByClass(Class clazz, String templateRootDir,boolean isDelete) throws Exception, FileNotFoundException {
			Generator g = getGenerator(templateRootDir);
			GeneratorModel m = GeneratorModelUtils.newFromClass(clazz);
			PrintUtils.printBeginProcess("JavaClass:"+clazz.getSimpleName(),isDelete);
			processByGeneratorModel(templateRootDir, isDelete, g, m);
    	}

        private void processByGeneratorModel(String templateRootDir,
                                             boolean isDelete, Generator g,
                                             GeneratorModel m)
                                                              throws Exception,
                                                              FileNotFoundException {
            try {
				if(isDelete)
					g.deleteBy(m.templateModel, m.filePathModel);
				else
					g.generateBy(m.templateModel, m.filePathModel, false);
			}catch(GeneratorException ge) {
				PrintUtils.printExceptionsSumary(ge.getMessage(),getGenerator(templateRootDir).getOutRootDir(),ge.getExceptions());
			}
        }

        public void processByTable(String tableName,String templateRootDir,boolean isDelete) throws Exception {
        	if("*".equals(tableName)) {
        	    if(isDelete)
        	        deleteByAllTable(templateRootDir);
        	    else
        	        generateByAllTable(templateRootDir);
        		return;
        	}
    		Generator g = getGenerator(templateRootDir);
    		Table table = TableFactory.getInstance().getTable(tableName);
    		try {
    			processByTable(g,table,isDelete, false);
    		}catch(GeneratorException ge) {
    			PrintUtils.printExceptionsSumary(ge.getMessage(),getGenerator(templateRootDir).getOutRootDir(),ge.getExceptions());
    		}
    	}

		public void processByAllTable(String templateRootDir,boolean isDelete) throws Exception {
 			List<Table> tables = TableFactory.getInstance().getAllTables();

            //yq add
            List<Table> newtables = new ArrayList<Table>();
            List<Table> alreadytables = new ArrayList<Table>();
            boolean isAlreay = false;
            for(Table table : tables){
                //允许我多占用一会cpu
                for(String already : alreadyTbls){
                    if(table.getSqlName().toLowerCase().endsWith(already)){
                        isAlreay = true;
                        continue;
                    }
                }

				table.setSqlName(table.getSqlName().toLowerCase());
                if(!isAlreay) {
                    newtables.add(table);
                } else {
                    alreadytables.add(table);
                }
                isAlreay = false;
            }

			List exceptions = new ArrayList();
			for(int i = 0; i < newtables.size(); i++ ) {
				try {
					processByTable(getGenerator(templateRootDir),newtables.get(i),isDelete, false);
				}catch(GeneratorException ge) {
					exceptions.addAll(ge.getExceptions());
				}
			}

            //仅mybatis的公用部分
            for(int i = 0; i < alreadytables.size(); i++ ) {
                try {
                    processByTable(getGenerator(templateRootDir),alreadytables.get(i),isDelete, true);
                }catch(GeneratorException ge) {
                    exceptions.addAll(ge.getExceptions());
                }
            }
			PrintUtils.printExceptionsSumary("",getGenerator(templateRootDir).getOutRootDir(),exceptions);
		}

		public void processByTable(Generator g, Table table,boolean isDelete, boolean isCommon) throws Exception {
	        GeneratorModel m = GeneratorModelUtils.newFromTable(table);
	        PrintUtils.printBeginProcess(table.getSqlName()+" => "+table.getClassName(),isDelete);
	        if(isDelete)
	        	g.deleteBy(m.templateModel,m.filePathModel);
	        else {
                if(!isCommon) {
                    //${basepackage}.${persistence}
                    m.templateModel.put("mergePkg", m.templateModel.get("basepackage") + "." + m.templateModel.get("persistence"));
                    m.templateModel.put("mergePkgService", m.templateModel.get("basepackage") + ".service");
                    g.generateBy(m.templateModel, m.filePathModel, isCommon);
                } else {
                    m.templateModel.put("mergePkg", "cn.thinkjoy.common.managerui.dao");
                    m.templateModel.put("mergePkgService", "cn.thinkjoy.common.managerui.service");
                    g.generateBy(m.templateModel, m.filePathModel, isCommon);
                }
            }
	    }

        public void processByTableList(String templateRootDir,boolean isDelete) throws Exception {
            List<Table> tables = TableFactory.getInstance().getAllTables();
            GeneratorModel m = GeneratorModelUtils.newFromTables(tables);
//            PrintUtils.printBeginProcess(table.getSqlName()+" => "+table.getClassName(),isDelete);
            if(isDelete)
//                g.deleteBy(m.templateModel,m.filePathModel);
                getGenerator(templateRootDir).deleteBy(m.templateModel,m.filePathModel);
            else
//                g.generateBy(m.templateModel,m.filePathModel);
                getGenerator(templateRootDir).generateBy(m.templateModel,m.filePathModel, false);
        }
    }

    @SuppressWarnings("all")
	public static class GeneratorModelUtils {

        private static class Actions{
            private static List<Action> initList = new ArrayList<Action>();
            static{
                Action add = new Action("add", "新增");
                initList.add(add);

                add = new Action("edit", "修改");
                initList.add(add);

                add = new Action("del", "删除");
                initList.add(add);

                add = new Action("import", "导入数据");
                initList.add(add);

                add = new Action("export", "导出数据");
                initList.add(add);

                add = new Action("exportTpl", "导出模板");
                initList.add(add);
            }

            public static List<Action> getActions(){
                return initList;
            }
        }

		public static GeneratorModel newFromTable(Table table) {
			Map templateModel = new HashMap();
			templateModel.put("table", table);
			setShareVars(templateModel);

			Map filePathModel = new HashMap();
			setShareVars(filePathModel);
			filePathModel.putAll(BeanHelper.describe(table));
			return new GeneratorModel(templateModel,filePathModel);
		}

        public static GeneratorModel newFromTables(List<Table> tables) {
            Map templateModel = new HashMap();
            templateModel.put("tables", tables);

            //yq add
            List<Table> newtables = new ArrayList<Table>();
            boolean isAlreay = false;
            for(Table table : tables){
                //允许我多占用一会cpu
                for(String already : alreadyTbls){
                    if(table.getSqlName().endsWith(already)){
                        isAlreay = true;
                        continue;
                    }
                }

                if(!isAlreay) {
                    newtables.add(table);
                }
                isAlreay = false;
            }
            templateModel.put("newtables", newtables);

            //add by yq
            templateModel.put("parentRes", TableFactory.getInstance().getAllParentRes());
            templateModel.put("nums", NumGen.getMaps());
            templateModel.put("numsize", NumGen.getMaps().size());

            templateModel.put("actions", Actions.getActions());
            templateModel.put("times", System.currentTimeMillis());
            templateModel.put("bizSys", GeneratorProperties.getRequiredProperty("jdbc.databasename"));
            templateModel.put("basepackage", GeneratorProperties.getRequiredProperty("basepackage"));

            setShareVars(templateModel);

            Map filePathModel = new HashMap();
            setShareVars(filePathModel);
            filePathModel.putAll(BeanHelper.describe(tables));
            return new GeneratorModel(templateModel,filePathModel);
        }


		public static GeneratorModel newFromSql(Sql sql) throws Exception {
			Map templateModel = new HashMap();
			templateModel.put("sql", sql);
			setShareVars(templateModel);

			Map filePathModel = new HashMap();
			setShareVars(filePathModel);
			filePathModel.putAll(BeanHelper.describe(sql));
			return new GeneratorModel(templateModel,filePathModel);
		}

		public static GeneratorModel newFromClass(Class clazz) {
			Map templateModel = new HashMap();
			templateModel.put("clazz", new JavaClass(clazz));
			setShareVars(templateModel);

			Map filePathModel = new HashMap();
			setShareVars(filePathModel);
			filePathModel.putAll(BeanHelper.describe(new JavaClass(clazz)));
			return new GeneratorModel(templateModel,filePathModel);
		}

		public static GeneratorModel newFromMap(Map params) {
			Map templateModel = new HashMap();
			templateModel.putAll(params);
			setShareVars(templateModel);

			Map filePathModel = new HashMap();
			setShareVars(filePathModel);
			filePathModel.putAll(params);
			return new GeneratorModel(templateModel,filePathModel);
		}

		public static void setShareVars(Map templateModel) {
			templateModel.putAll(GeneratorProperties.getProperties());
			templateModel.putAll(System.getProperties());
			templateModel.put("env", System.getenv());
			templateModel.put("now", new Date());
			templateModel.putAll(GeneratorContext.getContext());
		}



	}

	private static class PrintUtils {

		private static void printExceptionsSumary(String msg,String outRoot,List<Exception> exceptions) throws FileNotFoundException {
			File errorFile = new File(outRoot,"generator_error.log");
			if(exceptions != null && exceptions.size() > 0) {
				System.err.println("[Generate Error Summary] : "+msg);
				PrintStream output = new PrintStream(new FileOutputStream(errorFile));
				for(int i = 0; i < exceptions.size(); i++) {
					Exception e = exceptions.get(i);
                    System.err.println("[GENERATE ERROR]:"+e);
					if(i == 0) e.printStackTrace();
					e.printStackTrace(output);
				}
				output.close();
				System.err.println("***************************************************************");
				System.err.println("* "+"* 输出目录已经生成generator_error.log用于查看错误 ");
				System.err.println("***************************************************************");
			}
		}

		private static void printBeginProcess(String displayText,boolean isDatele) {
			GLogger.println("***************************************************************");
			GLogger.println("* BEGIN " + (isDatele ? " delete by " : " generate by ")+ displayText);
			GLogger.println("***************************************************************");
		}

		public static void printAllTableNames(List<Table> tables) throws Exception {
			GLogger.println("\n----All TableNames BEGIN----");
			for(int i = 0; i < tables.size(); i++ ) {
				String sqlName = ((Table)tables.get(i)).getSqlName();
				GLogger.println("g.generateTable(\""+sqlName+"\");");
			}
			GLogger.println("----All TableNames END----");
		}
	}

}
