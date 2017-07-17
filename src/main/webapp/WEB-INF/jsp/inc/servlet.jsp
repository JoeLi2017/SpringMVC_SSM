<%@page import="net.wish30.auth.Constants"%>
<%@page import="net.wish30.cloud.platform.admin.resource.entity.Resource"%>
<%@page import="net.wish30.cloud.platform.auth.vo.UserLoginDetails"%>
<%@page import="org.apache.commons.lang3.StringUtils"%>
<%@page import="org.apache.shiro.SecurityUtils"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%
String path = request.getContextPath();
if(path!=null&&path.equals("/")) path = "";
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
request.setAttribute("path", path);
request.setAttribute("basePath", basePath);

UserLoginDetails userLoginDetails = (UserLoginDetails)SecurityUtils.getSubject().getSession().getAttribute(Constants.CURRENT_USER);
List<Resource> resources = new ArrayList<Resource>();
String username = "";
String headPhoto = "";
if (userLoginDetails != null) {
	resources = userLoginDetails.getResources();
	username = StringUtils.isNotBlank(userLoginDetails.getRealname())?userLoginDetails.getRealname():userLoginDetails.getUsername();
	headPhoto = userLoginDetails.getHeadPhoto();
	request.getSession().setAttribute("userId",userLoginDetails.getUserid());
	request.getSession().setAttribute("username", StringUtils.isNotBlank(userLoginDetails.getUsername())?userLoginDetails.getUsername():userLoginDetails.getRealname());
	//request.getSession().setAttribute("tenant",userLoginDetails.getTenant());
	request.getSession().setAttribute("isSystemAdminAccount", userLoginDetails.getType()==Constants.TYPE_TENANT?false:true);
	request.getSession().setAttribute("isSaas",userLoginDetails.getIsSaas());
}
String currentPage = (String) request.getSession().getAttribute(Constants.RESOURCE_QUERY_CODE);
String leftMenusid = (String) request.getSession().getAttribute(Constants.RESOURCE_ID);
String menuResourceId = (String) request.getSession().getAttribute(Constants.MENU_RESOURCE_ID);
%>
<script type="text/javascript">
var contextPath = "<%=path%>";
var currentPage = "<%=currentPage%>";
var leftMenusid = "<%=leftMenusid%>";
	var menuResourceId = "<%=menuResourceId%>"
</script>
