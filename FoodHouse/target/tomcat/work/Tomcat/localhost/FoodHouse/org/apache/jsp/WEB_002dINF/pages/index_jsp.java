/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2017-11-09 08:24:16 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!--A Design by W3layouts\r\n");
      out.write("Author: W3layout\r\n");
      out.write("Author URL: http://w3layouts.com\r\n");
      out.write("License: Creative Commons Attribution 3.0 Unported\r\n");
      out.write("License URL: http://creativecommons.org/licenses/by/3.0/\r\n");
      out.write("-->\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("<title>Food Club a Hotels and Restaurants Category Bootstrap responsive Website Template | Home :: w3layouts</title>\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("<meta charset=\"utf-8\">\r\n");
      out.write("<meta name=\"keywords\" content=\"Food Club Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, \r\n");
      out.write("Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design\" />\r\n");
      out.write("<script type=\"application/x-javascript\"> addEventListener(\"load\", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>\r\n");
      out.write("<!-- bootstrap-css -->\r\n");
      out.write("<link href=\"css/bootstrap.css\" rel=\"stylesheet\" type=\"text/css\" media=\"all\" />\r\n");
      out.write("<!--// bootstrap-css -->\r\n");
      out.write("<!-- css -->\r\n");
      out.write("<link rel=\"stylesheet\" href=\"css/style.css\" type=\"text/css\" media=\"all\" />\r\n");
      out.write("<!--// css -->\r\n");
      out.write("<!-- font-awesome icons -->\r\n");
      out.write("<link href=\"css/font-awesome.css\" rel=\"stylesheet\"> \r\n");
      out.write("<!-- //font-awesome icons -->\r\n");
      out.write("<!-- font -->\r\n");
      out.write("<link href=\"//fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i\" rel=\"stylesheet\">\r\n");
      out.write("<link href=\"//fonts.googleapis.com/css?family=Great+Vibes&amp;subset=latin-ext\" rel=\"stylesheet\">\r\n");
      out.write("<!-- //font -->\r\n");
      out.write("<script src=\"js/jquery-1.11.1.min.js\"></script>\r\n");
      out.write("<script src=\"js/bootstrap.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\tjQuery(document).ready(function($) {\r\n");
      out.write("\t\t$(\".scroll\").click(function(event){\t\t\r\n");
      out.write("\t\t\tevent.preventDefault();\r\n");
      out.write("\t\t\t$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);\r\n");
      out.write("\t\t});\r\n");
      out.write("\t});\r\n");
      out.write("</script> \r\n");
      out.write("\r\n");
      out.write("<!--[if lt IE 9]>\r\n");
      out.write("  <script src=\"https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js\"></script>\r\n");
      out.write("<![endif]-->\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<!-- banner -->\r\n");
      out.write("\t<div class=\"banner jarallax\">\r\n");
      out.write("\t\t<!-- agileinfo-dot -->\r\n");
      out.write("\t\t<div class=\"agileinfo-dot\">\r\n");
      out.write("\t\t\t<div class=\"w3layouts-header-top\">\r\n");
      out.write("\t\t\t\t<div class=\"w3-header-top-grids\">\r\n");
      out.write("\t\t\t\t\t<div class=\"w3-header-top-left\">\r\n");
      out.write("\t\t\t\t\t\t<p><i class=\"fa fa-home\" aria-hidden=\"true\"></i> 1st Street , mexico city</p>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"w3-header-top-right\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"agileinfo-social-grids\">\r\n");
      out.write("\t\t\t\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t\t\t\t<li><a href=\"#\"><i class=\"fa fa-facebook\"></i></a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<li><a href=\"#\"><i class=\"fa fa-twitter\"></i></a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<li><a href=\"#\"><i class=\"fa fa-rss\"></i></a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<li><a href=\"#\"><i class=\"fa fa-vk\"></i></a></li>\r\n");
      out.write("\t\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"w3-header-top-right-text\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"agileinfo-social-grids\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<li><a href=\"login\">Login</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<li><a href=\"signup\">Signup</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"clearfix\"> </div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"clearfix\"> </div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"head\">\r\n");
      out.write("\t\t\t\t<div class=\"head-nav-grids\">\r\n");
      out.write("\t\t\t\t\t<div class=\"navbar-top\">\r\n");
      out.write("\t\t\t\t\t\t\t<!-- Brand and toggle get grouped for better mobile display -->\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"navbar-header\">\r\n");
      out.write("\t\t\t\t\t\t\t  <button type=\"button\" class=\"navbar-toggle collapsed\" data-toggle=\"collapse\" data-target=\"#bs-example-navbar-collapse-1\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<span class=\"sr-only\">Toggle navigation</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t<span class=\"icon-bar\"></span>\r\n");
      out.write("\t\t\t\t\t\t\t\t<span class=\"icon-bar\"></span>\r\n");
      out.write("\t\t\t\t\t\t\t\t<span class=\"icon-bar\"></span>\r\n");
      out.write("\t\t\t\t\t\t\t  </button>\r\n");
      out.write("\t\t\t\t\t\t\t\t <div class=\"navbar-brand logo \">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<h1><a href=\"home\">Food <span>Club</span></a></h1>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<!-- Collect the nav links, forms, and other content for toggling -->\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"collapse navbar-collapse\" id=\"bs-example-navbar-collapse-1\">\r\n");
      out.write("\t\t\t\t\t\t\t <ul class=\"nav navbar-nav link-effect-4\">\r\n");
      out.write("\t\t\t\t\t\t\t<li class=\"active\"><a href=\"home\" data-hover=\"Home\">Home</a> </li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<li><a href=\"about\" data-hover=\"About\">About </a> </li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<li><a href=\"gallery\"  data-hover=\"Gallery\">Gallery</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<li><a href=\"our_branches\" data-hover=\"OurBranches\">Our Branches</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<li><a href=\"contact\" data-hover=\"Contact\">Contact</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t  </ul>\r\n");
      out.write("\t\t\t\t\t\t\t</div><!-- /.navbar-collapse -->\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\t\t<div class=\"header-left\">\r\n");
      out.write("\t\t\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t\t\t<li><i class=\"fa fa-envelope\" aria-hidden=\"true\"></i> <a href=\"mailto:info@example.com\">@example.com</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><i class=\"fa fa-fax\" aria-hidden=\"true\"></i> +1234 567 892</li>\r\n");
      out.write("\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"clearfix\"></div>\t\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"w3layouts-banner-slider\">\r\n");
      out.write("\t\t\t\t<div class=\"w3layouts-banner-top-slider\">\r\n");
      out.write("\t\t\t\t\t<div class=\"slider\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"callbacks_container\">\r\n");
      out.write("\t\t\t\t\t\t\t<ul class=\"rslides callbacks callbacks1\" id=\"slider4\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"agileits-banner-info\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<h3>Lorem ipsum <span>dolor sit amet</span></h3>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"w3-button\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<a href=\"single.html\">More</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"agileits-banner-info\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<h3>Donec posuere <span>cursus nibh</span></h3>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"w3-button\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<a href=\"single.html\">More</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"clearfix\"> </div>\r\n");
      out.write("\t\t\t\t\t\t<script src=\"js/responsiveslides.min.js\"></script>\r\n");
      out.write("\t\t\t\t\t\t<script>\r\n");
      out.write("\t\t\t\t\t\t\t// You can also use \"$(window).load(function() {\"\r\n");
      out.write("\t\t\t\t\t\t\t$(function () {\r\n");
      out.write("\t\t\t\t\t\t\t  // Slideshow 4\r\n");
      out.write("\t\t\t\t\t\t\t  $(\"#slider4\").responsiveSlides({\r\n");
      out.write("\t\t\t\t\t\t\t\tauto: true,\r\n");
      out.write("\t\t\t\t\t\t\t\tpager:true,\r\n");
      out.write("\t\t\t\t\t\t\t\tnav:true,\r\n");
      out.write("\t\t\t\t\t\t\t\tspeed: 500,\r\n");
      out.write("\t\t\t\t\t\t\t\tnamespace: \"callbacks\",\r\n");
      out.write("\t\t\t\t\t\t\t\tbefore: function () {\r\n");
      out.write("\t\t\t\t\t\t\t\t  $('.events').append(\"<li>before event fired.</li>\");\r\n");
      out.write("\t\t\t\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\t\t\t\tafter: function () {\r\n");
      out.write("\t\t\t\t\t\t\t\t  $('.events').append(\"<li>after event fired.</li>\");\r\n");
      out.write("\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t  });\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\t\t </script>\r\n");
      out.write("\t\t\t\t\t\t<!--banner Slider starts Here-->\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<!-- //agileinfo-dot -->\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<!-- //banner -->\r\n");
      out.write("\t<!-- welcome -->\r\n");
      out.write("\t<div class=\"welcome\">\r\n");
      out.write("\t\t<div class=\"container\">\r\n");
      out.write("\t\t\t<div class=\"agileinfo-heading\">\r\n");
      out.write("\t\t\t\t<h3>Welcome</h3>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"agileits-welcome-grids\">\r\n");
      out.write("\t\t\t\t<div class=\"col-md-5 agileits-welcome-left\">\r\n");
      out.write("\t\t\t\t\t<img src=\"images/2.jpg\" alt=\"\" />\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"col-md-7 agileits-welcome-left\">\r\n");
      out.write("\t\t\t\t\t<h2>Aenean et ultricies mi, ac ultricies ex. Cras iaculis lectus at orci dapibus efficitur.</h2>\r\n");
      out.write("\t\t\t\t\t<div class=\"agile-border\"> </div>\r\n");
      out.write("\t\t\t\t\t<p>Vivamus placerat velit placerat elementum vestibulum. Suspendisse faucibus, dui id sagittis dignissim, tortor mauris maximus turpis, eu vehicula est leo nec metus. Donec pellentesque felis sit amet vehicula iaculis. Fusce sollicitudin leo ipsum, nec mollis quam dignissim eu. <span>Vivamus pellentesque porttitor hendrerit. In dui justo, egestas at aliquam quis, mollis dictum ex. Curabitur laoreet pretium enim eu hendrerit. Donec vel consectetur mauris, eu malesuada magna. Praesent nec ultricies purus. Phasellus maximus efficitur velit, vel blandit diam elementum sed.</span></p>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"clearfix\"> </div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<!-- //welcome -->\r\n");
      out.write("\t<!-- special -->\r\n");
      out.write("\t<div class=\"special\">\r\n");
      out.write("\t\t<div class=\"container\">\r\n");
      out.write("\t\t\t<div class=\"agileinfo-heading\">\r\n");
      out.write("\t\t\t\t<h3>Specialities</h3>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"special-top-grids\">\r\n");
      out.write("\t\t\t\t<div class=\"w3-agile-special\">\r\n");
      out.write("\t\t\t\t\t");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t\t<div class=\"clearfix\"> </div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<!-- //special -->\r\n");
      out.write("\t<!-- history -->\r\n");
      out.write("\t<div class=\"history jarallax\">\r\n");
      out.write("\t\t<div class=\"history-dot\">\r\n");
      out.write("\t\t\t<div class=\"container\">\r\n");
      out.write("\t\t\t\t<div class=\"agileinfo-history-grids\">\r\n");
      out.write("\t\t\t\t\t<div class=\"slider\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"callbacks_container\">\r\n");
      out.write("\t\t\t\t\t\t\t<ul class=\"rslides\" id=\"slider3\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"wthree-history-info\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<h4>Lorem ipsum dolor sit amet, consectetur</h4>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<p>Mauris mollis, libero id ornare condimentum, erat mi iaculis libero, bibendum dictum leo tortor a magna. Aenean porta non nunc in semper. Fusce eget tempus metus, sit amet posuere lectus. Morbi cursus ante a felis ultrices scelerisque. Nullam cursus odio est, in pellentesque neque elementum nec. Pellentesque a egestas erat.</p>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<a href=\"about.html\">Read More</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"wthree-history-info\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<h4>Vivamus placerat velit placerat elementum</h4>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<p>Nullam tristique faucibus pharetra. Ut ultricies, dui a tincidunt placerat, urna augue pellentesque leo, et posuere velit neque quis justo. Vivamus vel nulla vel tellus pretium maximus. Pellentesque auctor euismod lectus a pretium. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.</p>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<a href=\"about.html\">Read More</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"wthree-history-info\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<h4>Donec pellentesque felis sit amet vehicula</h4>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<p>Donec viverra enim nunc, sit amet ultricies dolor placerat vestibulum. Donec id dapibus dolor. Praesent elementum ipsum fringilla ullamcorper facilisis. Morbi blandit tortor molestie ex dignissim, vitae blandit metus ullamcorper. Praesent eleifend risus quam, et aliquet eros tristique a. Duis rhoncus auctor urna, id tristique quam gravida in. </p>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<a href=\"about.html\">Read More</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<script>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t// You can also use \"$(window).load(function() {\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t$(function () {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t  // Slideshow 4\r\n");
      out.write("\t\t\t\t\t\t\t\t\t  $(\"#slider3\").responsiveSlides({\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tauto: true,\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tpager:false,\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tnav:false,\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tspeed: 500,\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tnamespace: \"callbacks\",\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tbefore: function () {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t  $('.events').append(\"<li>before event fired.</li>\");\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tafter: function () {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t  $('.events').append(\"<li>after event fired.</li>\");\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t  });\r\n");
      out.write("\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\t\t\t\t </script>\r\n");
      out.write("\t\t\t\t\t\t\t\t<!--banner Slider starts Here-->\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<!-- //history -->\r\n");
      out.write("\t<!-- subscribe -->\r\n");
      out.write("\t<div class=\"wthree-subscribe\">\r\n");
      out.write("\t\t<div class=\"container\">\r\n");
      out.write("\t\t\t<div class=\"agileinfo-heading\">\r\n");
      out.write("\t\t\t\t<h3>Newsletter</h3>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"w3-agileits-subscribe-form\">\r\n");
      out.write("\t\t\t\t<form action=\"#\" method=\"post\">\r\n");
      out.write("\t\t\t\t\t<input type=\"text\" placeholder=\"Subscribe\" name=\"Subscribe\" required=\"\">\r\n");
      out.write("\t\t\t\t\t<button class=\"btn1\">Subscribe</button>\r\n");
      out.write("\t\t\t\t</form>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<!-- //subscribe -->\r\n");
      out.write("\t<!-- footer -->\r\n");
      out.write("\t<div class=\"w3-agile-footer\">\r\n");
      out.write("\t\t<div class=\"container\">\r\n");
      out.write("\t\t\t<div class=\"footer-grids\">\r\n");
      out.write("\t\t\t\t<div class=\"col-md-3 footer-grid\">\r\n");
      out.write("\t\t\t\t\t<div class=\"footer-grid-heading\">\r\n");
      out.write("\t\t\t\t\t\t<h3><a href=\"home\">Food <span>Club</span></a></h3>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"agile-footer-info\">\r\n");
      out.write("\t\t\t\t\t\t<p>Maecenas pharetra scelerisque sem quis commodo. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Interdum et malesuada fames ac ante ipsum primis in faucibus.</p>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"social\">\r\n");
      out.write("\t\t\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"#\"><i class=\"fa fa-facebook\"></i></a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"#\"><i class=\"fa fa-twitter\"></i></a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"#\"><i class=\"fa fa-rss\"></i></a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"#\"><i class=\"fa fa-vk\"></i></a></li>\r\n");
      out.write("\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"col-md-3 footer-grid\">\r\n");
      out.write("\t\t\t\t\t<div class=\"footer-grid-heading\">\r\n");
      out.write("\t\t\t\t\t\t<h4>Address</h4>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"footer-grid-info\">\r\n");
      out.write("\t\t\t\t\t\t<p>Eiusmod Tempor inc\r\n");
      out.write("\t\t\t\t\t\t\t<span>St Dolore Place,Kingsport 56777.</span>\r\n");
      out.write("\t\t\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t\t\t<p class=\"phone\">Phone : +1 123 456 789\r\n");
      out.write("\t\t\t\t\t\t\t<span>Email : <a href=\"mailto:example@email.com\">mail@example.com</a></span>\r\n");
      out.write("\t\t\t\t\t\t\t<span>FAX : 123 456 7890</span>\r\n");
      out.write("\t\t\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"col-md-3 footer-grid\">\r\n");
      out.write("\t\t\t\t\t<div class=\"footer-grid-heading\">\r\n");
      out.write("\t\t\t\t\t\t<h4>Navigation</h4>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"footer-grid-info\">\r\n");
      out.write("\t\t\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"home\">Home</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"about\">About</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"gallery\">Gallery</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"icons\">Icons</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"codes\">Short Codes</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"contact\">Contact</a></li>\r\n");
      out.write("\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"col-md-3 footer-grid\">\r\n");
      out.write("\t\t\t\t\t<div class=\"footer-grid-heading\">\r\n");
      out.write("\t\t\t\t\t\t<h4>Twitter Posts</h4>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"agile-footer-grid\">\r\n");
      out.write("\t\t\t\t\t\t<ul class=\"w3agile_footer_grid_list\">\r\n");
      out.write("\t\t\t\t\t\t\t<li>Ut aut reiciendis voluptatibus maiores <a href=\"#\">http://example.com</a> alias, ut aut reiciendis.\r\n");
      out.write("\t\t\t\t\t\t\t\t<span><i class=\"fa fa-twitter\" aria-hidden=\"true\"></i> 02 days ago</span></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li>Itaque earum rerum hic tenetur a sapiente delectus <a href=\"#\">http://example.com</a><span><i class=\"fa fa-twitter\" aria-hidden=\"true\"></i> 03 days ago</span></li>\r\n");
      out.write("\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"clearfix\"> </div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"agileits-w3layouts-copyright\">\r\n");
      out.write("\t\t\t\t<p>© 2017 Food Club . All Rights Reserved | Design by <a href=\"http://w3layouts.com/\"> W3layouts</a> </p>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<!-- //footer -->\r\n");
      out.write("\t<script src=\"js/jarallax.js\"></script>\r\n");
      out.write("\t<script src=\"js/SmoothScroll.min.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\t\t/* init Jarallax */\r\n");
      out.write("\t\t$('.jarallax').jarallax({\r\n");
      out.write("\t\t\tspeed: 0.5,\r\n");
      out.write("\t\t\timgWidth: 1366,\r\n");
      out.write("\t\t\timgHeight: 768\r\n");
      out.write("\t\t})\r\n");
      out.write("\t</script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"js/move-top.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"js/easing.js\"></script>\r\n");
      out.write("\t<!-- here stars scrolling icon -->\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\t\t$(document).ready(function() {\r\n");
      out.write("\t\t\t/*\r\n");
      out.write("\t\t\t\tvar defaults = {\r\n");
      out.write("\t\t\t\tcontainerID: 'toTop', // fading element id\r\n");
      out.write("\t\t\t\tcontainerHoverID: 'toTopHover', // fading element hover id\r\n");
      out.write("\t\t\t\tscrollSpeed: 1200,\r\n");
      out.write("\t\t\t\teasingType: 'linear' \r\n");
      out.write("\t\t\t\t};\r\n");
      out.write("\t\t\t*/\r\n");
      out.write("\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t$().UItoTop({ easingType: 'easeOutQuart' });\r\n");
      out.write("\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t</script>\r\n");
      out.write("\t<!-- //here ends scrolling icon -->\r\n");
      out.write("</body>\t\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005fforEach_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f0.setParent(null);
    // /WEB-INF/pages/index.jsp(196,5) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/WEB-INF/pages/index.jsp(196,5) '${listSpecial }'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${listSpecial }",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    // /WEB-INF/pages/index.jsp(196,5) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVar("food");
    int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
      if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t\t\t<div class=\"col-md-3 special-grids\">\r\n");
          out.write("\t\t\t\t\t\t\t<div class=\"special-img\">\r\n");
          out.write("\t\t\t\t\t\t\t\t<img class=\"img-responsive\" src=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${food.image }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("\" alt=\"\">\r\n");
          out.write("\t\t\t\t\t\t\t\t<div class=\"captn\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t<div class=\"captn-top\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t<p>Aenean pulvinar ac enimet posuere tincidunt velit Utin tincidunt</p>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t<div class=\"wthree-special-info\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t<h4>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${food.name }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</h4>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
          out.write("\t\t\t\t\t\t\t\t</div>\r\n");
          out.write("\t\t\t\t\t\t\t</div>\r\n");
          out.write("\t\t\t\t\t\t</div>\r\n");
          out.write("\t\t\t\t\t");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f0.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
    }
    return false;
  }
}
