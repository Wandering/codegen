<nav class="navbar-default navbar-static-side" role="navigation">
    <div class="nav-close"><i class="fa fa-times-circle"></i>
    </div>
    <div class="sidebar-collapse">
        <ul class="nav" id="side-menu">
            <li class="nav-header">
                <div class="dropdown profile-element">
                    <span><img alt="image" class="img-circle" src="${path}/img/profile_small.jpg" tppabs="http://www.zi-han.net/theme/hplus/img/profile_small.jpg" /></span>
                    <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                                <span class="clear">
                               <span class="block m-t-xs"><strong class="font-bold">Beaut-zihan</strong></span>
                                <span class="text-muted text-xs block">超级管理员<b class="caret"></b></span>
                                </span>
                    </a>
                    <ul class="dropdown-menu animated fadeInRight m-t-xs">
                        <li><a class="J_menuItem" href="form_avatar.html" tppabs="http://www.zi-han.net/theme/hplus/form_avatar.html">修改头像</a>
                        </li>
                        <li><a class="J_menuItem" href="profile.html" tppabs="http://www.zi-han.net/theme/hplus/profile.html">个人资料</a>
                        </li>
                        <li><a class="J_menuItem" href="contacts.html" tppabs="http://www.zi-han.net/theme/hplus/contacts.html">联系我们</a>
                        </li>
                        <li><a class="J_menuItem" href="mailbox.html" tppabs="http://www.zi-han.net/theme/hplus/mailbox.html">信箱</a>
                        </li>
                        <li class="divider"></li>
                        <li><a href="login.html" tppabs="http://www.zi-han.net/theme/hplus/login.html">安全退出</a>
                        </li>
                    </ul>
                </div>
                <div class="logo-element">H+
                </div>
            </li>
            <#assign pr = null />
            <#list resources as resource>
            <#assign pr = "pr" />
                <#if parentTitle= resource.resource.name>
                <li class="active">
                <#else>
                <li>
                </#if>
                <a href="#">
                    <i class="fa fa-home"></i>
                    <span class="nav-label">${resource.resource.name}</span>
                    <span class="fa arrow"></span>
                </a>

                <ul class="nav nav-second-level">
                    <#if resource.list?exists>
                        <#list resource.list  as subresources>
                            <#if mainObj= subresources.resource.bizModelName >
                            <li>
                            <#else>
                            <li>
                            </#if>
                            <a class="J_menuItem" href="${subresources.resource.url}" data-index="0">${subresources.resource.name}</a>
                            </li>
                        </#list>
                    </#if>

                </ul>

                </li>
            </#list>

        </ul>
    </div>
</nav>
