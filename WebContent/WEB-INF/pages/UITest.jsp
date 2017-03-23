<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
  
<!-- Mirrored from condorthemes.com/cleanzone/form-elements.html by HTTrack Website Copier/3.x [XR&CO'2013], Mon, 31 Mar 2014 14:35:05 GMT -->
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="images/favicon.png">

    <title>Clean Zone</title>


    <!-- Bootstrap core CSS -->
    <link href="js/bootstrap/dist/css/bootstrap.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="js/bootstrap.switch/bootstrap-switch.min.css" />
	<link rel="stylesheet" type="text/css" href="js/bootstrap.datetimepicker/css/bootstrap-datetimepicker.min.css" />

	<!-- Select2 -->
	<link rel="stylesheet" type="text/css" href="js/jquery.select2/select2.css" />
	
	
	<!-- Slider -->
	<link rel="stylesheet" type="text/css" href="js/bootstrap.slider/css/slider.css" />
  
  <!-- DateRange -->
	<link rel="stylesheet" type="text/css" href="js/bootstrap.daterangepicker/daterangepicker-bs3.css" />
  
  <!-- Custom styles for this template -->
  <link href="css/style.css" rel="stylesheet" />

	<link rel="stylesheet" href="fonts/font-awesome-4/css/font-awesome.min.css">
	<link rel="stylesheet" href="css/pygments.css">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <![endif]-->
  <link rel="stylesheet" type="text/css" href="js/jquery.nanoscroller/nanoscroller.css" />
  <link href="js/jquery.icheck/skins/square/blue.css" rel="stylesheet">

</head>

<body>

<!-- Fixed navbar -->
<div id="head-nav" class="navbar navbar-default navbar-fixed-top">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
        <span class="fa fa-gear"></span>
      </button>
      <a class="navbar-brand" href="#"><span>Clean Zone</span></a>
    </div>
    <div class="navbar-collapse collapse">
      <ul class="nav navbar-nav">
        <li class="active"><a href="#">Home</a></li>
        <li><a href="#about">About</a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown">Contact <b class="caret"></b></a>
          <ul class="dropdown-menu">
            <li><a href="#">Action</a></li>
            <li><a href="#">Another action</a></li>
            <li><a href="#">Something else here</a></li>
    <li class="dropdown-submenu"><a href="#">Sub menu</a>
      <ul class="dropdown-menu">
        <li><a href="#">Action</a></li>
        <li><a href="#">Another action</a></li>
        <li><a href="#">Something else here</a></li>
        </ul>
    </li>              
    </ul>
        </li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown">Large menu <b class="caret"></b></a>
    <ul class="dropdown-menu col-menu-2">
      <li class="col-sm-6 no-padding">
        <ul>
        <li class="dropdown-header"><i class="fa fa-group"></i>Users</li>
        <li><a href="#">Action</a></li>
        <li><a href="#">Another action</a></li>
        <li><a href="#">Something else here</a></li>
        <li class="dropdown-header"><i class="fa fa-gear"></i>Config</li>
        <li><a href="#">Action</a></li>
        <li><a href="#">Another action</a></li>
        <li><a href="#">Something else here</a></li> 
        </ul>
      </li>
      <li  class="col-sm-6 no-padding">
        <ul>
        <li class="dropdown-header"><i class="fa fa-legal"></i>Sales</li>
        <li><a href="#">New sale</a></li>
        <li><a href="#">Register a product</a></li>
        <li><a href="#">Register a client</a></li> 
        <li><a href="#">Month sales</a></li>
        <li><a href="#">Delivered orders</a></li>
        </ul>
      </li>
    </ul>
        </li>
      </ul>
  <ul class="nav navbar-nav navbar-right user-nav">
    <li class="dropdown profile_menu">
      <a href="#" class="dropdown-toggle" data-toggle="dropdown"><img alt="Avatar" src="images/avatar2.jpg" />Jeff Hanneman <b class="caret"></b></a>
      <ul class="dropdown-menu">
        <li><a href="#">My Account</a></li>
        <li><a href="#">Profile</a></li>
        <li><a href="#">Messages</a></li>
        <li class="divider"></li>
        <li><a href="#">Sign Out</a></li>
      </ul>
    </li>
  </ul>			
  <ul class="nav navbar-nav navbar-right not-nav">
    <li class="button dropdown">
      <a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown"><i class=" fa fa-comments"></i></a>
      <ul class="dropdown-menu messages">
        <li>
          <div class="nano nscroller">
            <div class="content">
              <ul>
                <li>
                  <a href="#">
                    <img src="images/avatar2.jpg" alt="avatar" /><span class="date pull-right">13 Sept.</span> <span class="name">Daniel</span> I'm following you, and I want your money! 
                  </a>
                </li>
                <li>
                  <a href="#">
                    <img src="images/avatar_50.jpg" alt="avatar" /><span class="date pull-right">20 Oct.</span><span class="name">Adam</span> is now following you 
                  </a>
                </li>
                <li>
                  <a href="#">
                    <img src="images/avatar4_50.jpg" alt="avatar" /><span class="date pull-right">2 Nov.</span><span class="name">Michael</span> is now following you 
                  </a>
                </li>
                <li>
                  <a href="#">
                    <img src="images/avatar3_50.jpg" alt="avatar" /><span class="date pull-right">2 Nov.</span><span class="name">Lucy</span> is now following you 
                  </a>
                </li>
              </ul>
            </div>
          </div>
          <ul class="foot"><li><a href="#">View all messages </a></li></ul>           
        </li>
      </ul>
    </li>
    <li class="button dropdown">
      <a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-globe"></i><span class="bubble">2</span></a>
      <ul class="dropdown-menu">
        <li>
          <div class="nano nscroller">
            <div class="content">
              <ul>
                <li><a href="#"><i class="fa fa-cloud-upload info"></i><b>Daniel</b> is now following you <span class="date">2 minutes ago.</span></a></li>
                <li><a href="#"><i class="fa fa-male success"></i> <b>Michael</b> is now following you <span class="date">15 minutes ago.</span></a></li>
                <li><a href="#"><i class="fa fa-bug warning"></i> <b>Mia</b> commented on post <span class="date">30 minutes ago.</span></a></li>
                <li><a href="#"><i class="fa fa-credit-card danger"></i> <b>Andrew</b> killed someone <span class="date">1 hour ago.</span></a></li>
              </ul>
            </div>
          </div>
          <ul class="foot"><li><a href="#">View all activity </a></li></ul>           
        </li>
      </ul>
    </li>
    <li class="button"><a href="javascript:;" class="speech-button"><i class="fa fa-microphone"></i></a></li>				
  </ul>

    </div><!--/.nav-collapse -->
  </div>
</div>


<div id="cl-wrapper">
		<div class="cl-sidebar">
			<div class="cl-toggle"><i class="fa fa-bars"></i></div>
			<div class="cl-navblock">
        <div class="menu-space">
          <div class="content">
            <div class="side-user">
              <div class="avatar"><img src="images/avatar1_50.jpg" alt="Avatar" /></div>
              <div class="info">
                <a href="#">Jeff Hanneman</a>
                <img src="images/state_online.png" alt="Status" /> <span>Online</span>
              </div>
            </div>
            <ul class="cl-vnavigation">
              <li><a href="#"><i class="fa fa-home"></i><span>Dashboard</span></a>
                <ul class="sub-menu">
                  <li><a href="index-2.html">Version 1</a></li>
                  <li><a href="dashboard2.html"><span class="label label-primary pull-right">New</span> Version 2</a></li>
                </ul>
              </li>
              <li><a href="#"><i class="fa fa-smile-o"></i><span>UI Elements</span></a>
                <ul class="sub-menu">
                  <li><a href="ui-elements.html">General</a></li>
                  <li><a href="ui-buttons.html">Buttons</a></li>
                  <li><a href="ui-modals.html"><span class="label label-primary pull-right">New</span> Modals</a></li>
                  <li><a href="ui-notifications.html"><span class="label label-primary pull-right">New</span> Notifications</a></li>
                  <li><a href="ui-icons.html">Icons</a></li>
                  <li><a href="ui-grid.html">Grid</a></li>
                  <li><a href="ui-tabs-accordions.html">Tabs & Acordions</a></li>
                  <li><a href="ui-nestable-lists.html">Nestable Lists</a></li>
                  <li><a href="ui-treeview.html">Tree View</a></li>
                </ul>
              </li>
              <li><a href="#"><i class="fa fa-list-alt"></i><span>Forms</span></a>
                <ul class="sub-menu">
                  <li class="active"><a href="form-elements.html">Components</a></li>
                  <li><a href="form-validation.html">Validation</a></li>
                  <li><a href="form-wizard.html">Wizard</a></li>
                  <li><a href="form-masks.html">Input Masks</a></li>
                  <li><a href="form-multiselect.html"><span class="label label-primary pull-right">New</span>Multi Select</a></li>
                  <li><a href="form-wysiwyg.html"><span class="label label-primary pull-right">New</span>WYSIWYG Editor</a></li>
                  <li><a href="form-upload.html"><span class="label label-primary pull-right">New</span>Multi Upload</a></li>
                </ul>
              </li>
              <li><a href="#"><i class="fa fa-table"></i><span>Tables</span></a>
                <ul class="sub-menu">
                  <li><a href="tables-general.html">General</a></li>
                  <li><a href="tables-datatables.html"><span class="label label-primary pull-right">New</span>Data Tables</a></li>
                </ul>
              </li>              
              <li><a href="#"><i class="fa fa-map-marker nav-icon"></i><span>Maps</span></a>
                <ul class="sub-menu">
                  <li><a href="maps.html">Google Maps</a></li>
                  <li><a href="vector-maps.html"><span class="label label-primary pull-right">New</span>Vector Maps</a></li>
                </ul>
              </li>             
              <li><a href="#"><i class="fa fa-envelope nav-icon"></i><span>Email</span></a>
                <ul class="sub-menu">
                  <li><a href="email-inbox.html">Inbox</a></li>
                  <li><a href="email-read.html">Email Detail</a></li>
                  <li><a href="email-compose.html"><span class="label label-primary pull-right">New</span>Email Compose</a></li>
                </ul>
              </li>
              <li><a href="typography.html"><i class="fa fa-text-height"></i><span>Typography</span></a></li>
              <li><a href="charts.html"><i class="fa fa-bar-chart-o"></i><span>Charts</span></a></li>
              <li><a href="#"><i class="fa fa-file"></i><span>Pages</span></a>
                <ul class="sub-menu">
                  <li><a href="pages-blank.html">Blank Page</a></li>
                  <li><a href="pages-blank-header.html">Blank Page Header</a></li>
                  <li><a href="pages-blank-aside.html">Blank Page Aside</a></li>
                  <li><a href="pages-login.html">Login</a></li>
                  <li><a href="pages-404.html">404 Page</a></li>
                  <li><a href="pages-500.html">500 Page</a></li>
                  <li><a href="pages-sign-up.html"><span class="label label-primary pull-right">New</span>Sign Up</a></li>
                  <li><a href="pages-forgot-password.html"><span class="label label-primary pull-right">New</span>Forgot Password</a></li>
                  <li><a href="pages-profile.html"><span class="label label-primary pull-right">New</span>Profile</a></li>
                  <li><a href="pages-search.html"><span class="label label-primary pull-right">New</span>Search</a></li>
                  <li><a href="pages-calendar.html"><span class="label label-primary pull-right">New</span>Calendar</a></li>
                  <li><a href="pages-code-editor.html"><span class="label label-primary pull-right">New</span>Code Editor</a></li>
                  <li><a href="pages-gallery.html">Gallery</a></li>
                  <li><a href="pages-timeline.html">Timeline</a></li>
                </ul>
              </li>
            </ul>
          </div>
        </div>
        <div class="text-right collapse-button" style="padding:7px 9px;">
          <input type="text" class="form-control search" placeholder="Search..." />
          <button id="sidebar-collapse" class="btn btn-default" style=""><i style="color:#fff;" class="fa fa-angle-left"></i></button>
        </div>
			</div>
		</div>
 
  <div class="container-fluid" id="pcont">
    <div class="page-head">
      <h2>Form Elements</h2>
      <ol class="breadcrumb">
        <li><a href="#">Home</a></li>
        <li><a href="#">Form</a></li>
        <li class="active">Elements</li>
      </ol>
    </div>
    <div class="cl-mcont">
    <div class="row">
      <div class="col-sm-6 col-md-6">
        <div class="block-flat">
          <div class="header">							
            <h3>Basic Form</h3>
          </div>
          <div class="content">

          <form role="form"> 
            <div class="form-group">
              <label>Email address</label> <input type="email" placeholder="Enter email" class="form-control">
            </div>
            <div class="form-group"> 
              <label>Password</label> <input type="password" placeholder="Password" class="form-control">
            </div> 
            <div class="checkbox">
              <label> <input type="checkbox" class="icheck"> Remember me </label> </div> 
              <button class="btn btn-primary" type="submit">Submit</button>
              <button class="btn btn-default">Cancel</button>
            </form>
          
          </div>
        </div>				
      </div>
      
      <div class="col-sm-6 col-md-6">
        <div class="block-flat">
          <div class="header">							
            <h3>Horizontal Form</h3>
          </div>
          <div class="content">
            <form class="form-horizontal" role="form">
              <div class="form-group">
              <label for="inputEmail3" class="col-sm-2 control-label">Email</label>
              <div class="col-sm-10">
                <input type="email" class="form-control" id="inputEmail3" placeholder="Email">
              </div>
              </div>
              <div class="form-group">
              <label for="inputPassword3" class="col-sm-2 control-label">Password</label>
              <div class="col-sm-10">
                <input type="password" class="form-control" id="inputPassword3" placeholder="Password">
              </div>
              </div>
              <div class="form-group">
              <div class="col-sm-offset-2 col-sm-10">
                <div class="checkbox" >
                <label>
                  <input type="checkbox" class="icheck"> Remember me
                </label>
                </div>
              </div>
              </div>
              <div class="form-group">
              <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-primary">Registrer</button>
                <button class="btn btn-default">Cancel</button>
              </div>
              </div>
            </form>
          </div>
        </div>				
      </div>
    </div>
    
    <div class="row">
      <div class="col-md-12">
      
        <div class="block-flat">
          <div class="header">							
            <h3>Basic Elements</h3>
          </div>
          <div class="content">
             <form class="form-horizontal group-border-dashed" action="#" style="border-radius: 0px;">
              <div class="form-group">
                <label class="col-sm-3 control-label">Input Text</label>
                <div class="col-sm-6">
                  <input type="text" class="form-control">
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-3 control-label">Input Password</label>
                <div class="col-sm-6">
                  <input type="password" class="form-control">
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-3 control-label">Placeholder Input</label>
                <div class="col-sm-6">
                  <input type="text" class="form-control" placeholder="Placeholder text">
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-3 control-label">Disabled Input</label>
                <div class="col-sm-6">
                  <input type="text" disabled="disabled" class="form-control" placeholder="Disabled input text">
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-3 control-label">Readonly Input</label>
                <div class="col-sm-6">
                  <input type="text" readonly="readonly" class="form-control" value="Readonly input text">
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-3 control-label">Textarea</label>
                <div class="col-sm-6">
                  <textarea class="form-control"></textarea>
                </div>
              </div>
            </form>
          </div>
        </div>
        
        <div class="block-flat">
          <div class="header">							
            <h3>Select & Option Elements</h3>
          </div>
          <div class="content">
              <form class="form-horizontal group-border-dashed" action="#" style="border-radius: 0px;">
              <div class="form-group">
                <label class="col-sm-3 control-label">Basic Select</label>
                <div class="col-sm-6">
                  <select class="form-control">
                    <option>1</option>
                    <option>2</option>
                    <option>3</option>
                    <option>4</option>
                    <option>5</option>
                  </select>									
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-3 control-label">Multiple Select</label>
                <div class="col-sm-6">
                  <select multiple class="form-control">
                    <option>1</option>
                    <option>2</option>
                    <option>3</option>
                    <option>4</option>
                    <option>5</option>
                  </select>									
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-3 control-label">Radio</label>
                <div class="col-sm-6">
                  <div class="radio"> 
                    <label> <input type="radio" checked="" name="rad1" class="icheck"> Option 1</label> 
                  </div>
                  <div class="radio"> 
                    <label> <input type="radio" name="rad1" class="icheck"> Option 2</label> 
                  </div>
                  <div class="radio"> 
                    <label> <input type="radio" name="rad1" class="icheck"> Option 3</label> 
                  </div>
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-3 control-label">Inline Radio</label>
                <div class="col-sm-6">
                  <label class="radio-inline"> <input type="radio" checked="" name="rad1" class="icheck"> Option 1</label> 
                  <label class="radio-inline"> <input type="radio" name="rad1" class="icheck"> Option 2</label> 
                  <label class="radio-inline"> <input type="radio" name="rad1" class="icheck"> Option 3</label> 
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-3 control-label">Checkbox</label>
                <div class="col-sm-6">
                  <div class="radio"> 
                    <label> <input type="checkbox" checked="" name="check1" class="icheck"> Option 1</label> 
                  </div>
                  <div class="radio"> 
                    <label> <input type="checkbox" name="check2" class="icheck"> Option 2</label> 
                  </div>
                  <div class="radio"> 
                    <label> <input type="checkbox" name="check3" class="icheck"> Option 3</label> 
                  </div>
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-3 control-label">Inline Checkbox</label>
                <div class="col-sm-6">
                  <label class="checkbox-inline"> <input type="checkbox" checked="" name="rad1" class="icheck"> Option 1</label> 
                  <label class="checkbox-inline"> <input type="checkbox" name="rad1" class="icheck"> Option 2</label> 
                  <label class="checkbox-inline"> <input type="checkbox" name="rad1" class="icheck"> Option 3</label> 
                </div>
              </div>
            </form>
          </div>
        </div>

        <div class="block-flat">
          <div class="header">							
            <h3>Input Groups</h3>
          </div>
          <div class="content">
              <form class="form-horizontal group-border-dashed" action="#" style="border-radius: 0px;">
              <div class="form-group">
                <label class="col-sm-3 control-label">Input Text</label>
                <div class="col-sm-6">
                  <div class="input-group">
                    <span class="input-group-addon">@</span>
                    <input type="text" class="form-control" placeholder="Username">
                  </div>
                  <div class="input-group">
                    <input type="text" class="form-control">
                    <span class="input-group-addon">.00</span>
                  </div>

                  <div class="input-group">
                    <span class="input-group-addon">$</span>
                    <input type="text" class="form-control">
                    <span class="input-group-addon">.00</span>
                  </div>
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-3 control-label">Input Sizing</label>
                <div class="col-sm-6">
                  <div class="input-group input-group-lg">
                    <span class="input-group-addon">@</span>
                    <input type="text" class="form-control" placeholder="Username">
                  </div>

                  <div class="input-group">
                    <span class="input-group-addon">@</span>
                    <input type="text" class="form-control" placeholder="Username">
                  </div>

                  <div class="input-group input-group-sm">
                    <span class="input-group-addon">@</span>
                    <input type="text" class="form-control" placeholder="Username">
                  </div>
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-3 control-label">Checkbox & Radio</label>
                <div class="col-sm-6">
                  <div class="input-group">
                    <span class="input-group-addon">
                    <input type="checkbox">
                    </span>
                    <input type="text" class="form-control">
                  </div>	
                  <div class="input-group">
                    <span class="input-group-addon">
                    <input type="radio">
                    </span>
                    <input type="text" class="form-control">
                  </div>										
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-3 control-label">Button Addons</label>
                <div class="col-sm-6">
                  <div class="input-group">
                    <input type="text" class="form-control">
                    <span class="input-group-btn">
                    <button class="btn btn-primary" type="button">Go!</button>
                    </span>
                  </div>
                  <div class="input-group">
                    <input type="text" class="form-control">
                    <div class="input-group-btn">
                    <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">Action <span class="caret"></span></button>
                    <ul class="dropdown-menu pull-right">
                      <li><a href="#">Action</a></li>
                      <li><a href="#">Another action</a></li>
                      <li><a href="#">Something else here</a></li>
                      <li class="divider"></li>
                      <li><a href="#">Separated link</a></li>
                    </ul>
                    </div>
                  </div>
                  <div class="input-group">
                    <input type="text" class="form-control">
                    <div class="input-group-btn">
                      <button tabindex="-1" class="btn btn-default" type="button">Action</button>
                      <button tabindex="-1" data-toggle="dropdown" class="btn btn-primary dropdown-toggle" type="button">
                      <span class="caret"></span>
                      <span class="sr-only">Toggle Dropdown</span>
                      </button>
                      <ul role="menu" class="dropdown-menu pull-right">
                      <li><a href="#">Action</a></li>
                      <li><a href="#">Another action</a></li>
                      <li><a href="#">Something else here</a></li>
                      <li class="divider"></li>
                      <li><a href="#">Separated link</a></li>
                      </ul>
                    </div>
                  </div>
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-3 control-label">Readonly Input</label>
                <div class="col-sm-6">
                  <input type="text" readonly="readonly" class="form-control" value="Readonly input text">
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-3 control-label">Textarea</label>
                <div class="col-sm-6">
                  <textarea class="form-control"></textarea>
                </div>
              </div>
            </form>
          </div>
        </div>

        <div class="block-flat">
          <div class="header">							
            <h3>Switch</h3>
          </div>
          <div class="content">
              <form class="form-horizontal group-border-dashed" action="#" style="border-radius: 0px;">
              <div class="form-group">
                <label class="col-sm-3 control-label">Sizes</label>
                <div class="col-sm-6">
                
                  
                    <input class="switch" type="checkbox" checked data-size="mini" >
               
                  

                    <input class="switch" data-size="small" type="checkbox" checked>
							
                  

                    <input class="switch" type="checkbox" checked>

                  

                    <input class="switch" data-size="large" type="checkbox" checked>

                  

                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-3 control-label">Info</label>
                <div class="col-sm-6">
                  <input class="switch" type="checkbox" checked data-on-color="info" data-off-color="primary">								
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-3 control-label">Success</label>
                <div class="col-sm-6">
                  <input class="switch" type="checkbox" checked data-on-color="success" data-off-color="primary">								
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-3 control-label">Warning</label>
                <div class="col-sm-6">
                  <input class="switch" type="checkbox" checked data-on-color="warning">								
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-3 control-label">Danger</label>
                <div class="col-sm-6">
                  <input class="switch" data-label-text="TV" type="checkbox" checked data-on-color="danger">								
                </div>
              </div>
            </form>
          </div>
        </div>

        <div class="block-flat">
          <div class="header">							
            <h3>DateTime Picker</h3>
          </div>
          <div class="content">
              <form class="form-horizontal group-border-dashed" action="#" style="border-radius: 0px;">
              <div class="form-group">
                <label class="col-sm-3 control-label">Default</label>
                <div class="col-sm-6">
                  <input class="form-control datetime" size="16" type="text" value="" />
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-3 control-label">Read Only</label>
                <div class="col-sm-6">
                  <div class="input-group date datetime col-md-5 col-xs-7" data-date="1979-09-16T05:25:07Z" data-date-format="yyyy-mm-dd - HH:ii" data-link-field="dtp_input1">
                    <input class="form-control" size="16" type="text" value="" readonly>
                    <span class="input-group-addon btn btn-primary"><span class="glyphicon glyphicon-th"></span></span>
                  </div>									
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-3 control-label"> Only Date </label>
                <div class="col-sm-6">
                  <div class="input-group date datetime col-md-5 col-xs-7" data-min-view="2" data-date-format="yyyy-mm-dd">
                    <input class="form-control" size="16" type="text" value="" readonly>
                    <span class="input-group-addon btn btn-primary"><span class="glyphicon glyphicon-th"></span></span>
                  </div>					
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-3 control-label">Decade View</label>
                <div class="col-sm-6">
                  <div class="input-group date datetime col-md-5 col-xs-7" data-start-view="4" data-date="1979-09-16T05:25:07Z" data-date-format="yyyy-mm-dd - HH:ii" data-link-field="dtp_input1">
                    <input class="form-control" size="16" type="text" value="" />
                    <span class="input-group-addon btn btn-primary"><span class="glyphicon glyphicon-th"></span></span>
                  </div>									
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-3 control-label">Year View</label>
                <div class="col-sm-6">
                  <div class="input-group date datetime col-md-5 col-xs-7" data-start-view="3" data-date="1979-09-16T05:25:07Z" data-date-format="yyyy-mm-dd - HH:ii" data-link-field="dtp_input1">
                    <input class="form-control" size="16" type="text" value="" />
                    <span class="input-group-addon btn btn-primary"><span class="glyphicon glyphicon-th"></span></span>
                  </div>									
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-3 control-label">Month View</label>
                <div class="col-sm-6">
                  <div class="input-group date datetime col-md-5 col-xs-7" data-start-view="2" data-date="1979-09-16T05:25:07Z" data-date-format="yyyy-mm-dd - HH:ii" data-link-field="dtp_input1">
                    <input class="form-control" size="16" type="text" value="" />
                    <span class="input-group-addon btn btn-primary"><span class="glyphicon glyphicon-th"></span></span>
                  </div>									
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-3 control-label">Day View</label>
                <div class="col-sm-6">
                  <div class="input-group date datetime col-md-5 col-xs-7" data-start-view="1" data-date="1979-09-16T05:25:07Z" data-date-format="yyyy-mm-dd - HH:ii" data-link-field="dtp_input1">
                    <input class="form-control" size="16" type="text" value="" />
                    <span class="input-group-addon btn btn-primary"><span class="glyphicon glyphicon-th"></span></span>
                  </div>									
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-3 control-label">Hour View</label>
                <div class="col-sm-6">
                  <div class="input-group date datetime col-md-5 col-xs-7" data-start-view="0" data-date="1979-09-16T05:25:07Z" data-date-format="yyyy-mm-dd - HH:ii" data-link-field="dtp_input1">
                    <input class="form-control" size="16" type="text" value="" />
                    <span class="input-group-addon btn btn-primary"><span class="glyphicon glyphicon-th"></span></span>
                  </div>									
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-3 control-label">Day View Meridian</label>
                <div class="col-sm-6">
                  <div class="input-group date datetime col-md-5 col-xs-7" data-show-meridian="true" data-start-view="1" data-date="1979-09-16T05:25:07Z" data-date-format="yyyy-mm-dd - HH:ii" data-link-field="dtp_input1">
                    <input class="form-control" size="16" type="text" value="" />
                    <span class="input-group-addon btn btn-primary"><span class="glyphicon glyphicon-th"></span></span>
                  </div>									
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-3 control-label">Hour View Meridian</label>
                <div class="col-sm-6">
                  <div class="input-group date datetime col-md-5 col-xs-7" data-show-meridian="true" data-start-view="0" data-date="1979-09-16T05:25:07Z" data-date-format="yyyy-mm-dd - HH:ii" data-link-field="dtp_input1">
                    <input class="form-control" size="16" type="text" value="" />
                    <span class="input-group-addon btn btn-primary"><span class="glyphicon glyphicon-th"></span></span>
                  </div>									
                </div>
              </div>
            </form>
          </div>
        </div>
        
        <div class="block-flat">
          <div class="header">							
            <h3>Date Range Picker</h3>
          </div>
          <div class="content">
            <form class="form-horizontal group-border-dashed" action="#" style="border-radius: 0px;">
              <div class="form-group">
                <label class="col-sm-3 control-label">Reservation Dates</label>
                <div class="col-sm-6">
                 <fieldset>
                  <div class="control-group">
                    <div class="controls">
                     <div class="input-prepend input-group">
                       <span class="add-on input-group-addon primary"><span class="glyphicon glyphicon-th"></span></span><input type="text" style="width: 200px" name="reservation" id="reservation" class="form-control" value="03/18/2014 - 03/23/2014" /> 
                     </div>
                    </div>
                  </div>
                 </fieldset>
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-3 control-label">Date & Time Picker</label>
                <div class="col-sm-6">
                  <fieldset>
                    <div class="control-group">
                      <div class="controls">
                        <div class="input-prepend input-group">
                          <span class="add-on input-group-addon primary"><i class="glyphicon glyphicon-th"></i></span>
                          <input type="text" style="width: 300px" name="reservation" id="reservationtime" class="form-control" value="02/01/2014 1:00 PM - 02/05/2014 2:30 PM"  class="span4"/>
                        </div>
                      </div>
                    </div>
                  </fieldset>
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-3 control-label">Date & Time Picker</label>
                <div class="col-sm-4">
                  <div id="reportrange" class="pull-left" style="background: #fff; cursor: pointer; padding: 5px 10px; border: 1px solid #ccc">
                     <i class="glyphicon glyphicon-calendar fa fa-calendar"></i> 
                     <span></span> <b class="caret"></b>
                  </div>
                </div>
              </div>
            </form>
          </div>
        </div>

        <div class="block-flat">
          <div class="header">							
            <h3>Advanced Controls</h3>
          </div>
          <div class="content">
              <form class="form-horizontal group-border-dashed" action="#" style="border-radius: 0px;">
              <div class="form-group">
                <label class="col-sm-3 control-label">Select2</label>
                <div class="col-sm-6">
                  <select class="select2">
                     <optgroup label="Alaskan/Hawaiian Time Zone">
                       <option value="AK">Alaska</option>
                       <option value="HI">Hawaii</option>
                     </optgroup>
                     <optgroup label="Pacific Time Zone">
                       <option value="CA">California</option>
                       <option value="NV">Nevada</option>
                       <option value="OR">Oregon</option>
                       <option value="WA">Washington</option>
                     </optgroup>
                     <optgroup label="Mountain Time Zone">
                       <option value="AZ">Arizona</option>
                       <option value="CO">Colorado</option>
                       <option value="ID">Idaho</option>
                       <option value="MT">Montana</option><option value="NE">Nebraska</option>
                       <option value="NM">New Mexico</option>
                       <option value="ND">North Dakota</option>
                       <option value="UT">Utah</option>
                       <option value="WY">Wyoming</option>
                     </optgroup>
                     <optgroup label="Central Time Zone">
                       <option value="AL">Alabama</option>
                       <option value="AR">Arkansas</option>
                       <option value="IL">Illinois</option>
                       <option value="IA">Iowa</option>
                       <option value="KS">Kansas</option>
                       <option value="KY">Kentucky</option>
                       <option value="LA">Louisiana</option>
                       <option value="MN">Minnesota</option>
                       <option value="MS">Mississippi</option>
                       <option value="MO">Missouri</option>
                       <option value="OK">Oklahoma</option>
                       <option value="SD">South Dakota</option>
                       <option value="TX">Texas</option>
                       <option value="TN">Tennessee</option>
                       <option value="WI">Wisconsin</option>
                     </optgroup>
                     <optgroup label="Eastern Time Zone">
                       <option value="CT">Connecticut</option>
                       <option value="DE">Delaware</option>
                       <option value="FL">Florida</option>
                       <option value="GA">Georgia</option>
                       <option value="IN">Indiana</option>
                       <option value="ME">Maine</option>
                       <option value="MD">Maryland</option>
                       <option value="MA">Massachusetts</option>
                       <option value="MI">Michigan</option>
                       <option value="NH">New Hampshire</option><option value="NJ">New Jersey</option>
                       <option value="NY">New York</option>
                       <option value="NC">North Carolina</option>
                       <option value="OH">Ohio</option>
                       <option value="PA">Pennsylvania</option><option value="RI">Rhode Island</option><option value="SC">South Carolina</option>
                       <option value="VT">Vermont</option><option value="VA">Virginia</option>
                       <option value="WV">West Virginia</option>
                     </optgroup>
                  </select>
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-3 control-label">MultiTag Input</label>
                <div class="col-sm-6">
                  <input class="tags" type="hidden" value="brown,blue,green" />
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-3 control-label">Multitag from Select</label>
                <div class="col-sm-6">
                  <select class="select2" multiple>
                     <optgroup label="Alaskan/Hawaiian Time Zone">
                       <option value="AK">Alaska</option>
                       <option value="HI">Hawaii</option>
                     </optgroup>
                     <optgroup label="Pacific Time Zone">
                       <option value="CA">California</option>
                       <option value="NV">Nevada</option>
                       <option value="OR">Oregon</option>
                       <option value="WA">Washington</option>
                     </optgroup>
                     <optgroup label="Mountain Time Zone">
                       <option value="AZ">Arizona</option>
                       <option value="CO">Colorado</option>
                       <option value="ID">Idaho</option>
                       <option value="MT">Montana</option><option value="NE">Nebraska</option>
                       <option value="NM">New Mexico</option>
                       <option value="ND">North Dakota</option>
                       <option value="UT">Utah</option>
                       <option value="WY">Wyoming</option>
                     </optgroup>
                     <optgroup label="Central Time Zone">
                       <option value="AL">Alabama</option>
                       <option value="AR">Arkansas</option>
                       <option value="IL">Illinois</option>
                       <option value="IA">Iowa</option>
                       <option value="KS">Kansas</option>
                       <option value="KY">Kentucky</option>
                       <option value="LA">Louisiana</option>
                       <option value="MN">Minnesota</option>
                       <option value="MS">Mississippi</option>
                       <option value="MO">Missouri</option>
                       <option value="OK">Oklahoma</option>
                       <option value="SD">South Dakota</option>
                       <option value="TX">Texas</option>
                       <option value="TN">Tennessee</option>
                       <option value="WI">Wisconsin</option>
                     </optgroup>
                     <optgroup label="Eastern Time Zone">
                       <option value="CT">Connecticut</option>
                       <option value="DE">Delaware</option>
                       <option value="FL">Florida</option>
                       <option value="GA">Georgia</option>
                       <option value="IN">Indiana</option>
                       <option value="ME">Maine</option>
                       <option value="MD">Maryland</option>
                       <option value="MA">Massachusetts</option>
                       <option value="MI">Michigan</option>
                       <option value="NH">New Hampshire</option><option value="NJ">New Jersey</option>
                       <option value="NY">New York</option>
                       <option value="NC">North Carolina</option>
                       <option value="OH">Ohio</option>
                       <option value="PA">Pennsylvania</option><option value="RI">Rhode Island</option><option value="SC">South Carolina</option>
                       <option value="VT">Vermont</option><option value="VA">Virginia</option>
                       <option value="WV">West Virginia</option>
                     </optgroup>
                  </select>
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-3 control-label">Slider</label>
                <div class="col-sm-6">
                  <input type="text" class="bslider form-control" value="" />
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-3 control-label">Range Slider</label>
                <div class="col-sm-6">
                  <input class="bslider form-control" type="text" data-slider-value="[250,450]" data-slider-step="5" data-slider-max="1000" data-slider-min="10" value="" />
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-3 control-label">Vertical Slider</label>
                <div class="col-sm-6">
                  <input class="form-control bslider" type="text" data-slider-selection="after" data-slider-orientation="vertical" data-slider-value="-13" data-slider-step="1" data-slider-max="20" data-slider-min="-20" value="">
                  <input class="form-control bslider" type="text" data-slider-selection="after" data-slider-orientation="vertical" data-slider-value="-9" data-slider-step="1" data-slider-max="20" data-slider-min="-20" value="">
                  <input class="form-control bslider" type="text" data-slider-selection="after" data-slider-orientation="vertical" data-slider-value="-5" data-slider-step="1" data-slider-max="20" data-slider-min="-20" value="">
                  <input class="form-control bslider" type="text" data-slider-selection="after" data-slider-orientation="vertical" data-slider-value="-2" data-slider-step="1" data-slider-max="20" data-slider-min="-20" value="">
                  <input class="form-control bslider" type="text" data-slider-selection="after" data-slider-orientation="vertical" data-slider-value="-5" data-slider-step="1" data-slider-max="20" data-slider-min="-20" value="">
                  <input class="form-control bslider" type="text" data-slider-selection="after" data-slider-orientation="vertical" data-slider-value="-9" data-slider-step="1" data-slider-max="20" data-slider-min="-20" value="">
                  <input class="form-control bslider" type="text" data-slider-selection="after" data-slider-orientation="vertical" data-slider-value="-13" data-slider-step="1" data-slider-max="20" data-slider-min="-20" value="">
                </div>
              </div>
            </form>
          </div>
        </div>
        
      </div>
    </div>
    
    </div>
  </div> 
</div>
    
  <script src="js/jquery.js"></script>
  <script src="js/jquery.select2/select2.min.js" type="text/javascript"></script>
  <script src="js/jquery.parsley/dist/parsley.js" type="text/javascript"></script>
  <script src="js/bootstrap.slider/js/bootstrap-slider.js" type="text/javascript"></script>
	<script type="text/javascript" src="js/jquery.nanoscroller/jquery.nanoscroller.js"></script>
	<script type="text/javascript" src="js/jquery.nestable/jquery.nestable.js"></script>
	<script type="text/javascript" src="js/behaviour/general.js"></script>
  <script src="js/jquery.ui/jquery-ui.js" type="text/javascript"></script>
	<script type="text/javascript" src="js/bootstrap.switch/bootstrap-switch.js"></script>
	<script type="text/javascript" src="js/bootstrap.datetimepicker/js/bootstrap-datetimepicker.min.js"></script>
	<script type="text/javascript" src="js/jquery.icheck/icheck.min.js"></script>
  <script type="text/javascript" src="js/bootstrap.daterangepicker/moment.min.js"></script>
  <script type="text/javascript" src="js/bootstrap.daterangepicker/daterangepicker.js"></script>

  <script type="text/javascript">
    $(document).ready(function(){
      //initialize the javascript
      App.init();
      
      $('#reservation').daterangepicker();
      $('#reservationtime').daterangepicker({
        timePicker: true,
        timePickerIncrement: 30,
        format: 'MM/DD/YYYY h:mm A'
      });
      var cb = function(start, end) {
        $('#reportrange span').html(start.format('MMMM D, YYYY') + ' - ' + end.format('MMMM D, YYYY'));
        alert("Callback has fired: [" + start.format('MMMM D, YYYY') + " to " + end.format('MMMM D, YYYY') + "]");
      }

      var optionSet1 = {
        startDate: moment().subtract('days', 29),
        endDate: moment(),
        minDate: '01/01/2012',
        maxDate: '12/31/2014',
        dateLimit: { days: 60 },
        showDropdowns: true,
        showWeekNumbers: true,
        timePicker: false,
        timePickerIncrement: 1,
        timePicker12Hour: true,
        ranges: {
           'Today': [moment(), moment()],
           'Yesterday': [moment().subtract('days', 1), moment().subtract('days', 1)],
           'Last 7 Days': [moment().subtract('days', 6), moment()],
           'Last 30 Days': [moment().subtract('days', 29), moment()],
           'This Month': [moment().startOf('month'), moment().endOf('month')],
           'Last Month': [moment().subtract('month', 1).startOf('month'), moment().subtract('month', 1).endOf('month')]
        },
        opens: 'left',
        buttonClasses: ['btn'],
        applyClass: 'btn-small btn-primary',
        cancelClass: 'btn-small',
        format: 'MM/DD/YYYY',
        separator: ' to ',
        locale: {
            applyLabel: 'Submit',
            cancelLabel: 'Clear',
            fromLabel: 'From',
            toLabel: 'To',
            customRangeLabel: 'Custom',
            daysOfWeek: ['Su', 'Mo', 'Tu', 'We', 'Th', 'Fr','Sa'],
            monthNames: ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'],
            firstDay: 1
        }
      };

      var optionSet2 = {
        startDate: moment().subtract('days', 7),
        endDate: moment(),
        opens: 'left',
        ranges: {
           'Today': [moment(), moment()],
           'Yesterday': [moment().subtract('days', 1), moment().subtract('days', 1)],
           'Last 7 Days': [moment().subtract('days', 6), moment()],
           'Last 30 Days': [moment().subtract('days', 29), moment()],
           'This Month': [moment().startOf('month'), moment().endOf('month')],
           'Last Month': [moment().subtract('month', 1).startOf('month'), moment().subtract('month', 1).endOf('month')]
        }
      };

      $('#reportrange span').html(moment().subtract('days', 29).format('MMMM D, YYYY') + ' - ' + moment().format('MMMM D, YYYY'));

      $('#reportrange').daterangepicker(optionSet1, cb);

    });
  </script>
  <!-- Bootstrap core JavaScript
  ================================================== -->
  <!-- Placed at the end of the document so the pages load faster -->
    <script src="js/behaviour/voice-commands.js"></script>
  <script src="js/bootstrap/dist/js/bootstrap.min.js"></script>
</body>

<!-- Mirrored from condorthemes.com/cleanzone/form-elements.html by HTTrack Website Copier/3.x [XR&CO'2013], Mon, 31 Mar 2014 14:35:34 GMT -->
</html>
