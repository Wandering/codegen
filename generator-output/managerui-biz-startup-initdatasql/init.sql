-- model
INSERT INTO `managerui-biz-startup_model`(`id`,`name`,`tblName`,`description`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
VALUES('3','数据权限模型','cmc1_data_model','数据权限model', 0, now(), 0, 1, 10);
INSERT INTO `managerui-biz-startup_model`(`id`,`name`,`tblName`,`description`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
VALUES('4','数据权限模型1','cmc1_data_model2','数据权限model', 0, now(), 0, 1, 10);
INSERT INTO `managerui-biz-startup_model`(`id`,`name`,`tblName`,`description`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
VALUES('5','数据组','cmc1_datagroup','数据组', 0, now(), 0, 1, 10);
INSERT INTO `managerui-biz-startup_model`(`id`,`name`,`tblName`,`description`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
VALUES('6','数据组数据','cmc1_datagroup_data','数据组数据，数据组和数据的对应关系', 0, now(), 0, 1, 10);
INSERT INTO `managerui-biz-startup_model`(`id`,`name`,`tblName`,`description`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
VALUES('7','业务模型','cmc1_model','业务模型(人员、薪酬等)', 0, now(), 0, 1, 10);
INSERT INTO `managerui-biz-startup_model`(`id`,`name`,`tblName`,`description`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
VALUES('8','资源','cmc1_resource','资源，一般为页面', 0, now(), 0, 1, 10);
INSERT INTO `managerui-biz-startup_model`(`id`,`name`,`tblName`,`description`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
VALUES('9','资源操作','cmc1_resource_action','页面对应的操作', 0, now(), 0, 1, 10);
INSERT INTO `managerui-biz-startup_model`(`id`,`name`,`tblName`,`description`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
VALUES('10','资源grid','cmc1_resource_grid','页面 grid的元数据描述', 0, now(), 0, 1, 10);
INSERT INTO `managerui-biz-startup_model`(`id`,`name`,`tblName`,`description`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
VALUES('11','角色','cmc1_role','角色', 0, now(), 0, 1, 10);
INSERT INTO `managerui-biz-startup_model`(`id`,`name`,`tblName`,`description`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
VALUES('12','角色资源','cmc1_role_resource','角色所管辖的页面资源', 0, now(), 0, 1, 10);
INSERT INTO `managerui-biz-startup_model`(`id`,`name`,`tblName`,`description`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
VALUES('13','用户角色','cmc1_role_user','用户对应的角色', 0, now(), 0, 1, 10);
INSERT INTO `managerui-biz-startup_model`(`id`,`name`,`tblName`,`description`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
VALUES('14','用户数据组','cmc1_user_datagroup','用户和数据组对应关系', 0, now(), 0, 1, 10);


-- parent resource
INSERT INTO `managerui-biz-startup_resource`(`id`,`url`,`orderNum`,`parentId`,`number`,`longNumber`,`name`,`creator`,`createDate`,`lastModifier`,`lastModDate`,`description`,`modelId`, `bizModelName`)
VALUES('2','/admin/cmc1/基础管理1','2',0,'a2','a2','基础管理1',0,1447316307891,0,1447316307891,null,null, '');
INSERT INTO `managerui-biz-startup_resource`(`id`,`url`,`orderNum`,`parentId`,`number`,`longNumber`,`name`,`creator`,`createDate`,`lastModifier`,`lastModDate`,`description`,`modelId`, `bizModelName`)
VALUES('1','/admin/cmc1/基础管理','1',0,'a1','a1','基础管理',0,1447316307891,0,1447316307891,null,null, '');

-- resource



INSERT INTO `managerui-biz-startup_resource`(`id`,`url`,`orderNum`,`parentId`,`number`,`longNumber`,`name`,`creator`,`createDate`,`lastModifier`,`lastModDate`,`description`,`modelId`, `bizModelName`)
VALUES('3','/admin/cmc1/datamodel','3','1','a3','a1_a3','数据权限设置',0,1447316307891,0,1447316307891,null,'3', 'datamodel');


  -- resource_action
      INSERT INTO `managerui-biz-startup_resource_action` (`id`,`resourceId`,`name`,`actionAlias`,`creator`,`createDate`,`lastModifier`,`lastModDate`,`description`)
      VALUES(1,3,'新增','add',0,1447316307891,0,1447316307891,'新增');
      INSERT INTO `managerui-biz-startup_resource_action` (`id`,`resourceId`,`name`,`actionAlias`,`creator`,`createDate`,`lastModifier`,`lastModDate`,`description`)
      VALUES(2,3,'修改','edit',0,1447316307891,0,1447316307891,'修改');
      INSERT INTO `managerui-biz-startup_resource_action` (`id`,`resourceId`,`name`,`actionAlias`,`creator`,`createDate`,`lastModifier`,`lastModDate`,`description`)
      VALUES(3,3,'删除','del',0,1447316307891,0,1447316307891,'删除');
      INSERT INTO `managerui-biz-startup_resource_action` (`id`,`resourceId`,`name`,`actionAlias`,`creator`,`createDate`,`lastModifier`,`lastModDate`,`description`)
      VALUES(4,3,'导入数据','import',0,1447316307891,0,1447316307891,'导入数据');
      INSERT INTO `managerui-biz-startup_resource_action` (`id`,`resourceId`,`name`,`actionAlias`,`creator`,`createDate`,`lastModifier`,`lastModDate`,`description`)
      VALUES(5,3,'导出数据','export',0,1447316307891,0,1447316307891,'导出数据');
      INSERT INTO `managerui-biz-startup_resource_action` (`id`,`resourceId`,`name`,`actionAlias`,`creator`,`createDate`,`lastModifier`,`lastModDate`,`description`)
      VALUES(6,3,'导出模板','exportTpl',0,1447316307891,0,1447316307891,'导出模板');

  -- resource_grid
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(1,3,'ID','id',0,200,'{}',null,'','ID','datamodel', 0, 1, 0, 1, 0);
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(2,3,'创建人','creator',1,200,'{}',null,'','创建人','datamodel', 0, 1, 0, 1, 0);
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(3,3,'创建时间','createDate',2,200,'{}',null,'','创建时间','datamodel', 0, 1, 0, 1, 0);
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(4,3,'修改人','lastModifier',3,200,'{}',null,'','修改人','datamodel', 0, 1, 0, 1, 0);
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(5,3,'修改时间','lastModDate',4,200,'{}',null,'','修改时间','datamodel', 0, 1, 0, 1, 0);
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(6,3,'状态','status',5,200,'{}',null,'','状态','datamodel', 0, 1, 0, 1, 0);
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(7,3,'优先级','priority',6,200,'{}',null,'','优先级','datamodel', 0, 1, 0, 1, 0);
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(8,3,'其对应的模型主体id','modelId',7,200,'{}',null,'','其对应的模型主体id','datamodel', 0, 1, 0, 1, 0);
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(9,3,'分配的url','assignUrl',8,200,'{}',null,'','分配的url','datamodel', 0, 1, 0, 1, 0);
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(10,3,'追加数据权限的sql','whereSql',9,200,'{}',null,'','追加数据权限的sql','datamodel', 0, 1, 0, 1, 0);
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(11,3,'按**维度设置','name',10,200,'{}',null,'','按**维度设置','datamodel', 0, 1, 0, 1, 0);



INSERT INTO `managerui-biz-startup_resource`(`id`,`url`,`orderNum`,`parentId`,`number`,`longNumber`,`name`,`creator`,`createDate`,`lastModifier`,`lastModDate`,`description`,`modelId`, `bizModelName`)
VALUES('4','/admin/cmc1/datamodel2','4','2','a4','a2_a4','数据权限设置1',0,1447316307891,0,1447316307891,null,'4', 'datamodel2');


  -- resource_action
      INSERT INTO `managerui-biz-startup_resource_action` (`id`,`resourceId`,`name`,`actionAlias`,`creator`,`createDate`,`lastModifier`,`lastModDate`,`description`)
      VALUES(7,4,'新增','add',0,1447316307891,0,1447316307891,'新增');
      INSERT INTO `managerui-biz-startup_resource_action` (`id`,`resourceId`,`name`,`actionAlias`,`creator`,`createDate`,`lastModifier`,`lastModDate`,`description`)
      VALUES(8,4,'修改','edit',0,1447316307891,0,1447316307891,'修改');
      INSERT INTO `managerui-biz-startup_resource_action` (`id`,`resourceId`,`name`,`actionAlias`,`creator`,`createDate`,`lastModifier`,`lastModDate`,`description`)
      VALUES(9,4,'删除','del',0,1447316307891,0,1447316307891,'删除');
      INSERT INTO `managerui-biz-startup_resource_action` (`id`,`resourceId`,`name`,`actionAlias`,`creator`,`createDate`,`lastModifier`,`lastModDate`,`description`)
      VALUES(10,4,'导入数据','import',0,1447316307891,0,1447316307891,'导入数据');
      INSERT INTO `managerui-biz-startup_resource_action` (`id`,`resourceId`,`name`,`actionAlias`,`creator`,`createDate`,`lastModifier`,`lastModDate`,`description`)
      VALUES(11,4,'导出数据','export',0,1447316307891,0,1447316307891,'导出数据');
      INSERT INTO `managerui-biz-startup_resource_action` (`id`,`resourceId`,`name`,`actionAlias`,`creator`,`createDate`,`lastModifier`,`lastModDate`,`description`)
      VALUES(12,4,'导出模板','exportTpl',0,1447316307891,0,1447316307891,'导出模板');

  -- resource_grid
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(12,4,'ID','id',0,200,'{}',null,'','ID','datamodel2', 0, 1, 0, 1, 0);
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(13,4,'创建人','creator',1,200,'{}',null,'','创建人','datamodel2', 0, 1, 0, 1, 0);
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(14,4,'创建时间','createDate',2,200,'{}',null,'','创建时间','datamodel2', 0, 1, 0, 1, 0);
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(15,4,'修改人','lastModifier',3,200,'{}',null,'','修改人','datamodel2', 0, 1, 0, 1, 0);
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(16,4,'修改时间','lastModDate',4,200,'{}',null,'','修改时间','datamodel2', 0, 1, 0, 1, 0);
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(17,4,'状态','status',5,200,'{}',null,'','状态','datamodel2', 0, 1, 0, 1, 0);
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(18,4,'优先级','priority',6,200,'{}',null,'','优先级','datamodel2', 0, 1, 0, 1, 0);
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(19,4,'其对应的模型主体id','modelId',7,200,'{}',null,'','其对应的模型主体id','datamodel2', 0, 1, 0, 1, 0);
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(20,4,'分配的url','assignUrl',8,200,'{}',null,'','分配的url','datamodel2', 0, 1, 0, 1, 0);
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(21,4,'追加数据权限的sql','whereSql',9,200,'{}',null,'','追加数据权限的sql','datamodel2', 0, 1, 0, 1, 0);
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(22,4,'按**维度设置','name',10,200,'{}',null,'','按**维度设置','datamodel2', 0, 1, 0, 1, 0);



INSERT INTO `managerui-biz-startup_resource`(`id`,`url`,`orderNum`,`parentId`,`number`,`longNumber`,`name`,`creator`,`createDate`,`lastModifier`,`lastModDate`,`description`,`modelId`, `bizModelName`)
VALUES('5','/admin/cmc1/datagroup','5','1','a5','a1_a5','数据组管理',0,1447316307891,0,1447316307891,null,'5', 'datagroup');


  -- resource_action
      INSERT INTO `managerui-biz-startup_resource_action` (`id`,`resourceId`,`name`,`actionAlias`,`creator`,`createDate`,`lastModifier`,`lastModDate`,`description`)
      VALUES(13,5,'新增','add',0,1447316307891,0,1447316307891,'新增');
      INSERT INTO `managerui-biz-startup_resource_action` (`id`,`resourceId`,`name`,`actionAlias`,`creator`,`createDate`,`lastModifier`,`lastModDate`,`description`)
      VALUES(14,5,'修改','edit',0,1447316307891,0,1447316307891,'修改');
      INSERT INTO `managerui-biz-startup_resource_action` (`id`,`resourceId`,`name`,`actionAlias`,`creator`,`createDate`,`lastModifier`,`lastModDate`,`description`)
      VALUES(15,5,'删除','del',0,1447316307891,0,1447316307891,'删除');
      INSERT INTO `managerui-biz-startup_resource_action` (`id`,`resourceId`,`name`,`actionAlias`,`creator`,`createDate`,`lastModifier`,`lastModDate`,`description`)
      VALUES(16,5,'导入数据','import',0,1447316307891,0,1447316307891,'导入数据');
      INSERT INTO `managerui-biz-startup_resource_action` (`id`,`resourceId`,`name`,`actionAlias`,`creator`,`createDate`,`lastModifier`,`lastModDate`,`description`)
      VALUES(17,5,'导出数据','export',0,1447316307891,0,1447316307891,'导出数据');
      INSERT INTO `managerui-biz-startup_resource_action` (`id`,`resourceId`,`name`,`actionAlias`,`creator`,`createDate`,`lastModifier`,`lastModDate`,`description`)
      VALUES(18,5,'导出模板','exportTpl',0,1447316307891,0,1447316307891,'导出模板');

  -- resource_grid
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(23,5,'ID','id',0,200,'{}',null,'','ID','datagroup', 0, 1, 0, 1, 0);
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(24,5,'名称','name',1,200,'{}',null,'','名称','datagroup', 0, 1, 0, 1, 0);
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(25,5,'编码','number',2,200,'{}',null,'','编码','datagroup', 0, 1, 0, 1, 0);
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(26,5,'描述','description',3,200,'{}',null,'','描述','datagroup', 0, 1, 0, 1, 0);
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(27,5,'状态','status',4,200,'{}',null,'','状态','datagroup', 0, 1, 0, 1, 0);
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(28,5,'创建人','creator',5,200,'{}',null,'','创建人','datagroup', 0, 1, 0, 1, 0);
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(29,5,'创建时间','createDate',6,200,'{}',null,'','创建时间','datagroup', 0, 1, 0, 1, 0);
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(30,5,'修改人','lastModifier',7,200,'{}',null,'','修改人','datagroup', 0, 1, 0, 1, 0);
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(31,5,'修改时间','lastModDate',8,200,'{}',null,'','修改时间','datagroup', 0, 1, 0, 1, 0);



INSERT INTO `managerui-biz-startup_resource`(`id`,`url`,`orderNum`,`parentId`,`number`,`longNumber`,`name`,`creator`,`createDate`,`lastModifier`,`lastModDate`,`description`,`modelId`, `bizModelName`)
VALUES('6','/admin/cmc1/datagroupdata','6','1','a6','a1_a6','数据组分配',0,1447316307891,0,1447316307891,null,'6', 'datagroupdata');


  -- resource_action
      INSERT INTO `managerui-biz-startup_resource_action` (`id`,`resourceId`,`name`,`actionAlias`,`creator`,`createDate`,`lastModifier`,`lastModDate`,`description`)
      VALUES(19,6,'新增','add',0,1447316307891,0,1447316307891,'新增');
      INSERT INTO `managerui-biz-startup_resource_action` (`id`,`resourceId`,`name`,`actionAlias`,`creator`,`createDate`,`lastModifier`,`lastModDate`,`description`)
      VALUES(20,6,'修改','edit',0,1447316307891,0,1447316307891,'修改');
      INSERT INTO `managerui-biz-startup_resource_action` (`id`,`resourceId`,`name`,`actionAlias`,`creator`,`createDate`,`lastModifier`,`lastModDate`,`description`)
      VALUES(21,6,'删除','del',0,1447316307891,0,1447316307891,'删除');
      INSERT INTO `managerui-biz-startup_resource_action` (`id`,`resourceId`,`name`,`actionAlias`,`creator`,`createDate`,`lastModifier`,`lastModDate`,`description`)
      VALUES(22,6,'导入数据','import',0,1447316307891,0,1447316307891,'导入数据');
      INSERT INTO `managerui-biz-startup_resource_action` (`id`,`resourceId`,`name`,`actionAlias`,`creator`,`createDate`,`lastModifier`,`lastModDate`,`description`)
      VALUES(23,6,'导出数据','export',0,1447316307891,0,1447316307891,'导出数据');
      INSERT INTO `managerui-biz-startup_resource_action` (`id`,`resourceId`,`name`,`actionAlias`,`creator`,`createDate`,`lastModifier`,`lastModDate`,`description`)
      VALUES(24,6,'导出模板','exportTpl',0,1447316307891,0,1447316307891,'导出模板');

  -- resource_grid
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(32,6,'ID','id',0,200,'{}',null,'','ID','datagroupdata', 0, 1, 0, 1, 0);
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(33,6,'创建人','creator',1,200,'{}',null,'','创建人','datagroupdata', 0, 1, 0, 1, 0);
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(34,6,'创建时间','createDate',2,200,'{}',null,'','创建时间','datagroupdata', 0, 1, 0, 1, 0);
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(35,6,'修改人','lastModifier',3,200,'{}',null,'','修改人','datagroupdata', 0, 1, 0, 1, 0);
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(36,6,'修改时间','lastModDate',4,200,'{}',null,'','修改时间','datagroupdata', 0, 1, 0, 1, 0);
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(37,6,'状态','status',5,200,'{}',null,'','状态','datagroupdata', 0, 1, 0, 1, 0);
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(38,6,'数据权限model id','dataModelId',6,200,'{}',null,'','数据权限model id','datagroupdata', 0, 1, 0, 1, 0);
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(39,6,'对应id','dataId',7,200,'{}',null,'','对应id','datagroupdata', 0, 1, 0, 1, 0);
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(40,6,'数据组id','groupId',8,200,'{}',null,'','数据组id','datagroupdata', 0, 1, 0, 1, 0);



INSERT INTO `managerui-biz-startup_resource`(`id`,`url`,`orderNum`,`parentId`,`number`,`longNumber`,`name`,`creator`,`createDate`,`lastModifier`,`lastModDate`,`description`,`modelId`, `bizModelName`)
VALUES('7','/admin/cmc1/model','7','1','a7','a1_a7','业务模型',0,1447316307891,0,1447316307891,null,'7', 'model');


  -- resource_action
      INSERT INTO `managerui-biz-startup_resource_action` (`id`,`resourceId`,`name`,`actionAlias`,`creator`,`createDate`,`lastModifier`,`lastModDate`,`description`)
      VALUES(25,7,'新增','add',0,1447316307891,0,1447316307891,'新增');
      INSERT INTO `managerui-biz-startup_resource_action` (`id`,`resourceId`,`name`,`actionAlias`,`creator`,`createDate`,`lastModifier`,`lastModDate`,`description`)
      VALUES(26,7,'修改','edit',0,1447316307891,0,1447316307891,'修改');
      INSERT INTO `managerui-biz-startup_resource_action` (`id`,`resourceId`,`name`,`actionAlias`,`creator`,`createDate`,`lastModifier`,`lastModDate`,`description`)
      VALUES(27,7,'删除','del',0,1447316307891,0,1447316307891,'删除');
      INSERT INTO `managerui-biz-startup_resource_action` (`id`,`resourceId`,`name`,`actionAlias`,`creator`,`createDate`,`lastModifier`,`lastModDate`,`description`)
      VALUES(28,7,'导入数据','import',0,1447316307891,0,1447316307891,'导入数据');
      INSERT INTO `managerui-biz-startup_resource_action` (`id`,`resourceId`,`name`,`actionAlias`,`creator`,`createDate`,`lastModifier`,`lastModDate`,`description`)
      VALUES(29,7,'导出数据','export',0,1447316307891,0,1447316307891,'导出数据');
      INSERT INTO `managerui-biz-startup_resource_action` (`id`,`resourceId`,`name`,`actionAlias`,`creator`,`createDate`,`lastModifier`,`lastModDate`,`description`)
      VALUES(30,7,'导出模板','exportTpl',0,1447316307891,0,1447316307891,'导出模板');

  -- resource_grid
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(41,7,'ID','id',0,200,'{}',null,'','ID','model', 0, 1, 0, 1, 0);
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(42,7,'创建人','creator',1,200,'{}',null,'','创建人','model', 0, 1, 0, 1, 0);
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(43,7,'创建时间','createDate',2,200,'{}',null,'','创建时间','model', 0, 1, 0, 1, 0);
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(44,7,'修改人','lastModifier',3,200,'{}',null,'','修改人','model', 0, 1, 0, 1, 0);
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(45,7,'修改时间','lastModDate',4,200,'{}',null,'','修改时间','model', 0, 1, 0, 1, 0);
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(46,7,'状态','status',5,200,'{}',null,'','状态','model', 0, 1, 0, 1, 0);
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(47,7,'名称','name',6,200,'{}',null,'','名称','model', 0, 1, 0, 1, 0);
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(48,7,'对应表名','tblName',7,200,'{}',null,'','对应表名','model', 0, 1, 0, 1, 0);
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(49,7,'描述','description',8,200,'{}',null,'','描述','model', 0, 1, 0, 1, 0);



INSERT INTO `managerui-biz-startup_resource`(`id`,`url`,`orderNum`,`parentId`,`number`,`longNumber`,`name`,`creator`,`createDate`,`lastModifier`,`lastModDate`,`description`,`modelId`, `bizModelName`)
VALUES('8','/admin/cmc1/resource','8','1','a8','a1_a8','资源管理',0,1447316307891,0,1447316307891,null,'8', 'resource');


  -- resource_action
      INSERT INTO `managerui-biz-startup_resource_action` (`id`,`resourceId`,`name`,`actionAlias`,`creator`,`createDate`,`lastModifier`,`lastModDate`,`description`)
      VALUES(31,8,'新增','add',0,1447316307891,0,1447316307891,'新增');
      INSERT INTO `managerui-biz-startup_resource_action` (`id`,`resourceId`,`name`,`actionAlias`,`creator`,`createDate`,`lastModifier`,`lastModDate`,`description`)
      VALUES(32,8,'修改','edit',0,1447316307891,0,1447316307891,'修改');
      INSERT INTO `managerui-biz-startup_resource_action` (`id`,`resourceId`,`name`,`actionAlias`,`creator`,`createDate`,`lastModifier`,`lastModDate`,`description`)
      VALUES(33,8,'删除','del',0,1447316307891,0,1447316307891,'删除');
      INSERT INTO `managerui-biz-startup_resource_action` (`id`,`resourceId`,`name`,`actionAlias`,`creator`,`createDate`,`lastModifier`,`lastModDate`,`description`)
      VALUES(34,8,'导入数据','import',0,1447316307891,0,1447316307891,'导入数据');
      INSERT INTO `managerui-biz-startup_resource_action` (`id`,`resourceId`,`name`,`actionAlias`,`creator`,`createDate`,`lastModifier`,`lastModDate`,`description`)
      VALUES(35,8,'导出数据','export',0,1447316307891,0,1447316307891,'导出数据');
      INSERT INTO `managerui-biz-startup_resource_action` (`id`,`resourceId`,`name`,`actionAlias`,`creator`,`createDate`,`lastModifier`,`lastModDate`,`description`)
      VALUES(36,8,'导出模板','exportTpl',0,1447316307891,0,1447316307891,'导出模板');

  -- resource_grid
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(50,8,'ID','id',0,200,'{}',null,'','ID','resource', 0, 1, 0, 1, 0);
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(51,8,'页面url','url',1,200,'{}',null,'','页面url','resource', 0, 1, 0, 1, 0);
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(52,8,'顺序','orderNum',2,200,'{}',null,'','顺序','resource', 0, 1, 0, 1, 0);
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(53,8,'父页面,null为顶层页面','parentId',3,200,'{}',null,'','父页面,null为顶层页面','resource', 0, 1, 0, 1, 0);
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(54,8,'编码','number',4,200,'{}',null,'','编码','resource', 0, 1, 0, 1, 0);
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(55,8,'长编码','longNumber',5,200,'{}',null,'','长编码','resource', 0, 1, 0, 1, 0);
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(56,8,'资源名称','name',6,200,'{}',null,'','资源名称','resource', 0, 1, 0, 1, 0);
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(57,8,'创建人','creator',7,200,'{}',null,'','创建人','resource', 0, 1, 0, 1, 0);
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(58,8,'创建时间','createDate',8,200,'{}',null,'','创建时间','resource', 0, 1, 0, 1, 0);
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(59,8,'修改人','lastModifier',9,200,'{}',null,'','修改人','resource', 0, 1, 0, 1, 0);
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(60,8,'修改时间','lastModDate',10,200,'{}',null,'','修改时间','resource', 0, 1, 0, 1, 0);
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(61,8,'描述','description',11,200,'{}',null,'','描述','resource', 0, 1, 0, 1, 0);
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(62,8,'主模型id  和 数据权限相关','modelId',12,200,'{}',null,'','主模型id  和 数据权限相关','resource', 0, 1, 0, 1, 0);
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(63,8,'业务模型名称','bizModelName',13,200,'{}',null,'','在同一个业务系统里不允许有同名的业务模型','resource', 0, 1, 0, 1, 0);



INSERT INTO `managerui-biz-startup_resource`(`id`,`url`,`orderNum`,`parentId`,`number`,`longNumber`,`name`,`creator`,`createDate`,`lastModifier`,`lastModDate`,`description`,`modelId`, `bizModelName`)
VALUES('9','/admin/cmc1/resourceaction','9','1','a9','a1_a9','资源管理',0,1447316307891,0,1447316307891,null,'9', 'resourceaction');


  -- resource_action
      INSERT INTO `managerui-biz-startup_resource_action` (`id`,`resourceId`,`name`,`actionAlias`,`creator`,`createDate`,`lastModifier`,`lastModDate`,`description`)
      VALUES(37,9,'新增','add',0,1447316307891,0,1447316307891,'新增');
      INSERT INTO `managerui-biz-startup_resource_action` (`id`,`resourceId`,`name`,`actionAlias`,`creator`,`createDate`,`lastModifier`,`lastModDate`,`description`)
      VALUES(38,9,'修改','edit',0,1447316307891,0,1447316307891,'修改');
      INSERT INTO `managerui-biz-startup_resource_action` (`id`,`resourceId`,`name`,`actionAlias`,`creator`,`createDate`,`lastModifier`,`lastModDate`,`description`)
      VALUES(39,9,'删除','del',0,1447316307891,0,1447316307891,'删除');
      INSERT INTO `managerui-biz-startup_resource_action` (`id`,`resourceId`,`name`,`actionAlias`,`creator`,`createDate`,`lastModifier`,`lastModDate`,`description`)
      VALUES(40,9,'导入数据','import',0,1447316307891,0,1447316307891,'导入数据');
      INSERT INTO `managerui-biz-startup_resource_action` (`id`,`resourceId`,`name`,`actionAlias`,`creator`,`createDate`,`lastModifier`,`lastModDate`,`description`)
      VALUES(41,9,'导出数据','export',0,1447316307891,0,1447316307891,'导出数据');
      INSERT INTO `managerui-biz-startup_resource_action` (`id`,`resourceId`,`name`,`actionAlias`,`creator`,`createDate`,`lastModifier`,`lastModDate`,`description`)
      VALUES(42,9,'导出模板','exportTpl',0,1447316307891,0,1447316307891,'导出模板');

  -- resource_grid
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(64,9,'ID','id',0,200,'{}',null,'','ID','resourceaction', 0, 1, 0, 1, 0);
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(65,9,'所属资源id','resourceId',1,200,'{}',null,'','所属资源id','resourceaction', 0, 1, 0, 1, 0);
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(66,9,'页面元素id','divId',2,200,'{}',null,'','页面元素id','resourceaction', 0, 1, 0, 1, 0);
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(67,9,'按钮对应的操作脚本','actionScript',3,200,'{}',null,'','按钮对应的操作脚本','resourceaction', 0, 1, 0, 1, 0);
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(68,9,'操作名称','name',4,200,'{}',null,'','操作名称','resourceaction', 0, 1, 0, 1, 0);
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(69,9,'操作标识','actionAlias',5,200,'{}',null,'','操作标识','resourceaction', 0, 1, 0, 1, 0);
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(70,9,'创建人','creator',6,200,'{}',null,'','创建人','resourceaction', 0, 1, 0, 1, 0);
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(71,9,'创建时间','createDate',7,200,'{}',null,'','创建时间','resourceaction', 0, 1, 0, 1, 0);
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(72,9,'修改人','lastModifier',8,200,'{}',null,'','修改人','resourceaction', 0, 1, 0, 1, 0);
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(73,9,'修改时间','lastModDate',9,200,'{}',null,'','修改时间','resourceaction', 0, 1, 0, 1, 0);
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(74,9,'描述','description',10,200,'{}',null,'','描述','resourceaction', 0, 1, 0, 1, 0);



INSERT INTO `managerui-biz-startup_resource`(`id`,`url`,`orderNum`,`parentId`,`number`,`longNumber`,`name`,`creator`,`createDate`,`lastModifier`,`lastModDate`,`description`,`modelId`, `bizModelName`)
VALUES('10','/admin/cmc1/resourcegrid','10','1','b1','a1_b1','资源grid管理',0,1447316307891,0,1447316307891,null,'10', 'resourcegrid');


  -- resource_action
      INSERT INTO `managerui-biz-startup_resource_action` (`id`,`resourceId`,`name`,`actionAlias`,`creator`,`createDate`,`lastModifier`,`lastModDate`,`description`)
      VALUES(43,10,'新增','add',0,1447316307891,0,1447316307891,'新增');
      INSERT INTO `managerui-biz-startup_resource_action` (`id`,`resourceId`,`name`,`actionAlias`,`creator`,`createDate`,`lastModifier`,`lastModDate`,`description`)
      VALUES(44,10,'修改','edit',0,1447316307891,0,1447316307891,'修改');
      INSERT INTO `managerui-biz-startup_resource_action` (`id`,`resourceId`,`name`,`actionAlias`,`creator`,`createDate`,`lastModifier`,`lastModDate`,`description`)
      VALUES(45,10,'删除','del',0,1447316307891,0,1447316307891,'删除');
      INSERT INTO `managerui-biz-startup_resource_action` (`id`,`resourceId`,`name`,`actionAlias`,`creator`,`createDate`,`lastModifier`,`lastModDate`,`description`)
      VALUES(46,10,'导入数据','import',0,1447316307891,0,1447316307891,'导入数据');
      INSERT INTO `managerui-biz-startup_resource_action` (`id`,`resourceId`,`name`,`actionAlias`,`creator`,`createDate`,`lastModifier`,`lastModDate`,`description`)
      VALUES(47,10,'导出数据','export',0,1447316307891,0,1447316307891,'导出数据');
      INSERT INTO `managerui-biz-startup_resource_action` (`id`,`resourceId`,`name`,`actionAlias`,`creator`,`createDate`,`lastModifier`,`lastModDate`,`description`)
      VALUES(48,10,'导出模板','exportTpl',0,1447316307891,0,1447316307891,'导出模板');

  -- resource_grid
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(75,10,'ID','id',0,200,'{}',null,'','ID','resourcegrid', 0, 1, 0, 1, 0);
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(76,10,'创建人','creator',1,200,'{}',null,'','创建人','resourcegrid', 0, 1, 0, 1, 0);
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(77,10,'创建时间','createDate',2,200,'{}',null,'','创建时间','resourcegrid', 0, 1, 0, 1, 0);
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(78,10,'修改人','lastModifier',3,200,'{}',null,'','修改人','resourcegrid', 0, 1, 0, 1, 0);
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(79,10,'修改时间','lastModDate',4,200,'{}',null,'','修改时间','resourcegrid', 0, 1, 0, 1, 0);
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(80,10,'状态','status',5,200,'{}',null,'','状态','resourcegrid', 0, 1, 0, 1, 0);
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(81,10,'资源id','resId',6,200,'{}',null,'','资源id','resourcegrid', 0, 1, 0, 1, 0);
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(82,10,' 显示名称','displayName',7,200,'{}',null,'',' 显示名称','resourcegrid', 0, 1, 0, 1, 0);
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(83,10,'grid列id','colId',8,200,'{}',null,'','grid列id','resourcegrid', 0, 1, 0, 1, 0);
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(84,10,'顺序号','orderNum',9,200,'{}',null,'','顺序号','resourcegrid', 0, 1, 0, 1, 0);
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(85,10,'显示的宽度','width',10,200,'{}',null,'','显示的宽度','resourcegrid', 0, 1, 0, 1, 0);
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(86,10,'编辑器类型','edittype',11,200,'{}',null,'','编辑器类型','resourcegrid', 0, 1, 0, 1, 0);
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(87,10,'是否可编辑','editable',12,200,'{}',null,'','false,编辑页面不显示','resourcegrid', 0, 1, 0, 1, 0);
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(88,10,'json','editoptions',13,200,'{}',null,'','json','resourcegrid', 0, 1, 0, 1, 0);
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(89,10,'校验规则','editrules',14,200,'{}',null,'','提交到服务器前的有效性校验','resourcegrid', 0, 1, 0, 1, 0);
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(90,10,'格式化函数','formatter',15,200,'{}',null,'','格式化函数','resourcegrid', 0, 1, 0, 1, 0);
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(91,10,'格式化参数json','formatoptions',16,200,'{}',null,'','格式化参数json','resourcegrid', 0, 1, 0, 1, 0);
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(92,10,'扩展编辑器','unformat',17,200,'{}',null,'','扩展编辑器','resourcegrid', 0, 1, 0, 1, 0);
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(93,10,'隐藏','hide',18,200,'{}',null,'','1列表和编辑页面都不显示','resourcegrid', 0, 1, 0, 1, 0);
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(94,10,'不可编辑','unedit',19,200,'{}',null,'','编辑页面不可编辑，但在表格和编辑页面显示','resourcegrid', 0, 1, 0, 1, 0);
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(95,10,'描述','description',20,200,'{}',null,'','描述','resourcegrid', 0, 1, 0, 1, 0);
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(96,10,'模块名称','moduleName',21,200,'{}',null,'','模块名称','resourcegrid', 0, 1, 0, 1, 0);



INSERT INTO `managerui-biz-startup_resource`(`id`,`url`,`orderNum`,`parentId`,`number`,`longNumber`,`name`,`creator`,`createDate`,`lastModifier`,`lastModDate`,`description`,`modelId`, `bizModelName`)
VALUES('11','/admin/cmc1/role','11','1','b2','a1_b2','角色管理',0,1447316307891,0,1447316307891,null,'11', 'role');


  -- resource_action
      INSERT INTO `managerui-biz-startup_resource_action` (`id`,`resourceId`,`name`,`actionAlias`,`creator`,`createDate`,`lastModifier`,`lastModDate`,`description`)
      VALUES(49,11,'新增','add',0,1447316307891,0,1447316307891,'新增');
      INSERT INTO `managerui-biz-startup_resource_action` (`id`,`resourceId`,`name`,`actionAlias`,`creator`,`createDate`,`lastModifier`,`lastModDate`,`description`)
      VALUES(50,11,'修改','edit',0,1447316307891,0,1447316307891,'修改');
      INSERT INTO `managerui-biz-startup_resource_action` (`id`,`resourceId`,`name`,`actionAlias`,`creator`,`createDate`,`lastModifier`,`lastModDate`,`description`)
      VALUES(51,11,'删除','del',0,1447316307891,0,1447316307891,'删除');
      INSERT INTO `managerui-biz-startup_resource_action` (`id`,`resourceId`,`name`,`actionAlias`,`creator`,`createDate`,`lastModifier`,`lastModDate`,`description`)
      VALUES(52,11,'导入数据','import',0,1447316307891,0,1447316307891,'导入数据');
      INSERT INTO `managerui-biz-startup_resource_action` (`id`,`resourceId`,`name`,`actionAlias`,`creator`,`createDate`,`lastModifier`,`lastModDate`,`description`)
      VALUES(53,11,'导出数据','export',0,1447316307891,0,1447316307891,'导出数据');
      INSERT INTO `managerui-biz-startup_resource_action` (`id`,`resourceId`,`name`,`actionAlias`,`creator`,`createDate`,`lastModifier`,`lastModDate`,`description`)
      VALUES(54,11,'导出模板','exportTpl',0,1447316307891,0,1447316307891,'导出模板');

  -- resource_grid
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(97,11,'ID','id',0,200,'{}',null,'','ID','role', 0, 1, 0, 1, 0);
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(98,11,'角色名称','name',1,200,'{}',null,'','角色名称','role', 0, 1, 0, 1, 0);
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(99,11,'创建人','creator',2,200,'{}',null,'','创建人','role', 0, 1, 0, 1, 0);
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(100,11,'创建时间','createDate',3,200,'{}',null,'','创建时间','role', 0, 1, 0, 1, 0);
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(101,11,'修改人','lastModifier',4,200,'{}',null,'','修改人','role', 0, 1, 0, 1, 0);
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(102,11,'修改时间','lastModDate',5,200,'{}',null,'','修改时间','role', 0, 1, 0, 1, 0);
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(103,11,'描述','description',6,200,'{}',null,'','描述','role', 0, 1, 0, 1, 0);



INSERT INTO `managerui-biz-startup_resource`(`id`,`url`,`orderNum`,`parentId`,`number`,`longNumber`,`name`,`creator`,`createDate`,`lastModifier`,`lastModDate`,`description`,`modelId`, `bizModelName`)
VALUES('12','/admin/cmc1/roleresource','12','1','b3','a1_b3','角色资源分配',0,1447316307891,0,1447316307891,null,'12', 'roleresource');


  -- resource_action
      INSERT INTO `managerui-biz-startup_resource_action` (`id`,`resourceId`,`name`,`actionAlias`,`creator`,`createDate`,`lastModifier`,`lastModDate`,`description`)
      VALUES(55,12,'新增','add',0,1447316307891,0,1447316307891,'新增');
      INSERT INTO `managerui-biz-startup_resource_action` (`id`,`resourceId`,`name`,`actionAlias`,`creator`,`createDate`,`lastModifier`,`lastModDate`,`description`)
      VALUES(56,12,'修改','edit',0,1447316307891,0,1447316307891,'修改');
      INSERT INTO `managerui-biz-startup_resource_action` (`id`,`resourceId`,`name`,`actionAlias`,`creator`,`createDate`,`lastModifier`,`lastModDate`,`description`)
      VALUES(57,12,'删除','del',0,1447316307891,0,1447316307891,'删除');
      INSERT INTO `managerui-biz-startup_resource_action` (`id`,`resourceId`,`name`,`actionAlias`,`creator`,`createDate`,`lastModifier`,`lastModDate`,`description`)
      VALUES(58,12,'导入数据','import',0,1447316307891,0,1447316307891,'导入数据');
      INSERT INTO `managerui-biz-startup_resource_action` (`id`,`resourceId`,`name`,`actionAlias`,`creator`,`createDate`,`lastModifier`,`lastModDate`,`description`)
      VALUES(59,12,'导出数据','export',0,1447316307891,0,1447316307891,'导出数据');
      INSERT INTO `managerui-biz-startup_resource_action` (`id`,`resourceId`,`name`,`actionAlias`,`creator`,`createDate`,`lastModifier`,`lastModDate`,`description`)
      VALUES(60,12,'导出模板','exportTpl',0,1447316307891,0,1447316307891,'导出模板');

  -- resource_grid
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(104,12,'ID','id',0,200,'{}',null,'','ID','roleresource', 0, 1, 0, 1, 0);
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(105,12,'创建人','creator',1,200,'{}',null,'','创建人','roleresource', 0, 1, 0, 1, 0);
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(106,12,'创建时间','createDate',2,200,'{}',null,'','创建时间','roleresource', 0, 1, 0, 1, 0);
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(107,12,'修改人','lastModifier',3,200,'{}',null,'','修改人','roleresource', 0, 1, 0, 1, 0);
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(108,12,'修改时间','lastModDate',4,200,'{}',null,'','修改时间','roleresource', 0, 1, 0, 1, 0);
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(109,12,'状态','status',5,200,'{}',null,'','状态','roleresource', 0, 1, 0, 1, 0);
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(110,12,'资源id','resourceId',6,200,'{}',null,'','资源id','roleresource', 0, 1, 0, 1, 0);
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(111,12,'功能按钮id','resourceActionId',7,200,'{}',null,'','功能按钮id','roleresource', 0, 1, 0, 1, 0);
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(112,12,'角色id','roleId',8,200,'{}',null,'','角色id','roleresource', 0, 1, 0, 1, 0);



INSERT INTO `managerui-biz-startup_resource`(`id`,`url`,`orderNum`,`parentId`,`number`,`longNumber`,`name`,`creator`,`createDate`,`lastModifier`,`lastModDate`,`description`,`modelId`, `bizModelName`)
VALUES('13','/admin/cmc1/roleuser','13','1','b4','a1_b4','用户角色分配',0,1447316307891,0,1447316307891,null,'13', 'roleuser');


  -- resource_action
      INSERT INTO `managerui-biz-startup_resource_action` (`id`,`resourceId`,`name`,`actionAlias`,`creator`,`createDate`,`lastModifier`,`lastModDate`,`description`)
      VALUES(61,13,'新增','add',0,1447316307891,0,1447316307891,'新增');
      INSERT INTO `managerui-biz-startup_resource_action` (`id`,`resourceId`,`name`,`actionAlias`,`creator`,`createDate`,`lastModifier`,`lastModDate`,`description`)
      VALUES(62,13,'修改','edit',0,1447316307891,0,1447316307891,'修改');
      INSERT INTO `managerui-biz-startup_resource_action` (`id`,`resourceId`,`name`,`actionAlias`,`creator`,`createDate`,`lastModifier`,`lastModDate`,`description`)
      VALUES(63,13,'删除','del',0,1447316307891,0,1447316307891,'删除');
      INSERT INTO `managerui-biz-startup_resource_action` (`id`,`resourceId`,`name`,`actionAlias`,`creator`,`createDate`,`lastModifier`,`lastModDate`,`description`)
      VALUES(64,13,'导入数据','import',0,1447316307891,0,1447316307891,'导入数据');
      INSERT INTO `managerui-biz-startup_resource_action` (`id`,`resourceId`,`name`,`actionAlias`,`creator`,`createDate`,`lastModifier`,`lastModDate`,`description`)
      VALUES(65,13,'导出数据','export',0,1447316307891,0,1447316307891,'导出数据');
      INSERT INTO `managerui-biz-startup_resource_action` (`id`,`resourceId`,`name`,`actionAlias`,`creator`,`createDate`,`lastModifier`,`lastModDate`,`description`)
      VALUES(66,13,'导出模板','exportTpl',0,1447316307891,0,1447316307891,'导出模板');

  -- resource_grid
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(113,13,'ID','id',0,200,'{}',null,'','ID','roleuser', 0, 1, 0, 1, 0);
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(114,13,'创建人','creator',1,200,'{}',null,'','创建人','roleuser', 0, 1, 0, 1, 0);
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(115,13,'创建时间','createDate',2,200,'{}',null,'','创建时间','roleuser', 0, 1, 0, 1, 0);
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(116,13,'修改人','lastModifier',3,200,'{}',null,'','修改人','roleuser', 0, 1, 0, 1, 0);
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(117,13,'修改时间','lastModDate',4,200,'{}',null,'','修改时间','roleuser', 0, 1, 0, 1, 0);
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(118,13,'状态','status',5,200,'{}',null,'','状态','roleuser', 0, 1, 0, 1, 0);
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(119,13,'用户id','userId',6,200,'{}',null,'','用户id','roleuser', 0, 1, 0, 1, 0);
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(120,13,'角色id','roleId',7,200,'{}',null,'','角色id','roleuser', 0, 1, 0, 1, 0);



INSERT INTO `managerui-biz-startup_resource`(`id`,`url`,`orderNum`,`parentId`,`number`,`longNumber`,`name`,`creator`,`createDate`,`lastModifier`,`lastModDate`,`description`,`modelId`, `bizModelName`)
VALUES('14','/admin/cmc1/userdatagroup','14','1','b5','a1_b5','用户数据组分配',0,1447316307891,0,1447316307891,null,'14', 'userdatagroup');


  -- resource_action
      INSERT INTO `managerui-biz-startup_resource_action` (`id`,`resourceId`,`name`,`actionAlias`,`creator`,`createDate`,`lastModifier`,`lastModDate`,`description`)
      VALUES(67,14,'新增','add',0,1447316307891,0,1447316307891,'新增');
      INSERT INTO `managerui-biz-startup_resource_action` (`id`,`resourceId`,`name`,`actionAlias`,`creator`,`createDate`,`lastModifier`,`lastModDate`,`description`)
      VALUES(68,14,'修改','edit',0,1447316307891,0,1447316307891,'修改');
      INSERT INTO `managerui-biz-startup_resource_action` (`id`,`resourceId`,`name`,`actionAlias`,`creator`,`createDate`,`lastModifier`,`lastModDate`,`description`)
      VALUES(69,14,'删除','del',0,1447316307891,0,1447316307891,'删除');
      INSERT INTO `managerui-biz-startup_resource_action` (`id`,`resourceId`,`name`,`actionAlias`,`creator`,`createDate`,`lastModifier`,`lastModDate`,`description`)
      VALUES(70,14,'导入数据','import',0,1447316307891,0,1447316307891,'导入数据');
      INSERT INTO `managerui-biz-startup_resource_action` (`id`,`resourceId`,`name`,`actionAlias`,`creator`,`createDate`,`lastModifier`,`lastModDate`,`description`)
      VALUES(71,14,'导出数据','export',0,1447316307891,0,1447316307891,'导出数据');
      INSERT INTO `managerui-biz-startup_resource_action` (`id`,`resourceId`,`name`,`actionAlias`,`creator`,`createDate`,`lastModifier`,`lastModDate`,`description`)
      VALUES(72,14,'导出模板','exportTpl',0,1447316307891,0,1447316307891,'导出模板');

  -- resource_grid
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(121,14,'ID','id',0,200,'{}',null,'','ID','userdatagroup', 0, 1, 0, 1, 0);
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(122,14,'创建人','creator',1,200,'{}',null,'','创建人','userdatagroup', 0, 1, 0, 1, 0);
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(123,14,'创建时间','createDate',2,200,'{}',null,'','创建时间','userdatagroup', 0, 1, 0, 1, 0);
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(124,14,'修改人','lastModifier',3,200,'{}',null,'','修改人','userdatagroup', 0, 1, 0, 1, 0);
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(125,14,'修改时间','lastModDate',4,200,'{}',null,'','修改时间','userdatagroup', 0, 1, 0, 1, 0);
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(126,14,'状态','status',5,200,'{}',null,'','状态','userdatagroup', 0, 1, 0, 1, 0);
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(127,14,'数据组id','datagroupId',6,200,'{}',null,'','数据组id','userdatagroup', 0, 1, 0, 1, 0);
      INSERT INTO `managerui-biz-startup_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`)
      VALUES(128,14,'用户id','userId',7,200,'{}',null,'','用户id','userdatagroup', 0, 1, 0, 1, 0);
