<template>
  <div data-spy="scroll" data-target="#navbar-example">

    <!-- LOAD PAGE -->
    <div class="animationload">
        <div class="loader"></div>
    </div>

    <!-- BACK TO TOP SECTION -->
    <a href="#0" class="cd-top cd-is-visible cd-fade-out">Top</a>

    <!-- HEADER -->
    <div class="header header-1">
        <!-- MIDDLE BAR -->
        <div class="middlebar d-none d-sm-block">
            <div class="container">
                <div class="row align-items-center">
                    <div class="col-3 col-md-3">
                        <div class="logo">
                            <img src="images/logo.png" alt="" />
                        </div>
                    </div>
                    <div class="col-9 col-md-9">
                        <div class="contact-info">
                            <!-- INFO 1 -->
                            <div class="rs-icon-1">
                                <div class="icon">
                                    <div class="fas fa-envelope"></div>
                                </div>
                                <div class="body-content">
                                    <div class="heading">Email Support :</div>
                                    info@subsco.com
                                </div>
                            </div>
                            <!-- INFO 1 -->
                            <!-- <div class="rs-icon-1">
                                <div class="icon">
                                    <div class="fas fa-phone-volume"></div>
                                </div>
                                <div class="body-content">
                                    <div class="heading">Call Support :</div>
                                    +62 123 6700 411
                                </div>
                            </div> -->
                            <!-- INFO 2 -->
                            <!-- <div class="rs-icon-1">
                                <div class="icon">
                                    <div class="fas fa-clock"></div>
                                </div>
                                <div class="body-content">
                                    <div class="heading">Work Hour :</div>
                                    Mon - Fri 08:00 - 17:00
                                </div>
                            </div> -->
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- NAVBAR SECTION -->
        <div class="navbar-main">
            <div class="container">
                <nav id="navbar-example" class="navbar navbar-expand-lg navbar-bg">

                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarNavDropdown">
                        <ul class="navbar-nav">
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                  Home
                                </a>
                                <div class="dropdown-menu">
                                    <a class="dropdown-item" href="index.html">Homepage 1</a>
                                      <a class="dropdown-item" href="index-2.html">Homepage 2</a>
                                      <a class="dropdown-item" href="index-3.html">Homepage 3</a>
                                </div>
                            </li>

                            <li class="nav-item">
                                <a class="nav-link" href="about.html">About</a>
                            </li>

                            <li class="nav-item">
                                <a class="nav-link" href="services.html">Services</a>
                            </li>

                            <li class="nav-item dropdown active">
                                <a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                  Projects
                                </a>
                                <div class="dropdown-menu">
                                    <a class="dropdown-item" href="projects.html">Projects Grid</a>
                                    <a class="dropdown-item" href="projects-single.html">Projects Single</a>
                                </div>
                            </li>

                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                  News
                                </a>
                                <div class="dropdown-menu">
                                    <a class="dropdown-item" href="news.html">News Grid</a>
                                    <a class="dropdown-item" href="news-single.html">Single News</a>
                                </div>
                            </li>

                            <li class="nav-item">
                                <a class="nav-link" href="contact.html">Contact</a>
                            </li>

                        </ul>
                    </div>
                    <a href="#" class="btn btn-primary btn-navbar d-none d-sm-block">Get a Quote</a>
                </nav> <!-- Navbar -->

            </div>
        </div>

    </div>

    <!-- BANNER -->
    <div class="section banner-page" data-background="images/dummy-img-1920x1280.jpg">
    <!-- <div class="section banner-page" data-background="/images/img2-1920x1280.jpg"> -->
        <div class="content-wrap pos-relative">
            <div class="container">
                <div class="col-12 col-md-12">
                    <div class="d-flex bd-highlight mb-2">
                        <div class="title-page" :data="companyInfo">{{ companyInfo.English_name }}</div>
                    </div>
                    <nav aria-label="breadcrumb">
                      <ol class="breadcrumb ">
                        <li class="breadcrumb-item"><a href="index.html">Home</a></li>
                        <li class="breadcrumb-item active" aria-current="page">Single Projects</li>
                      </ol>
                    </nav>
                </div>
            </div>

        </div>
    </div>

    <!-- CONTENT -->
    <div id="class" class="">
        <div class="content-wrap">
            <div class="container">
                <div class="row">

                    <div class="col-sm-12 col-md-12 col-lg-8">

                        <div class="single-page">
                            <h4 class="text-black uk21">
                                简介
                            </h4>
                            <p>阿里巴巴集团控股有限公司是一家电子商务企业,旗下拥有淘宝,天猫,聚划算,1688等多个品牌。集团经营多元化的互联网业务,致力为全球所有人创造便捷的交易渠道。自成立以来,阿里巴巴集团建立了消费者电子商务、网上支付、B2B网上交易市场及云计算业务,近几年更积极开拓无线应用、手机操作系统和互联网电视等领域。集团以促进一个开放、协同、繁荣的电子商务生态系统为目标,旨在对消费者、商家以及经济发展做出贡献。阿里巴巴是主要从事电子商务,是网上交易市场和商务交流社区,融合了B2B、C2C、搜索引擎和门户。阿里巴巴两次入选哈佛大学商学MBA案例,在美国学术界掀起研究热潮;连续五次被美国权威财经杂志《福布斯》选为全球最佳B2B站点之一;多次被相关机构评为全球最受欢迎的B2B网站、中国商务类优秀网站、中国百家优秀网站、中国最佳贸易网。被国内外媒体、硅谷和国外风险投资家誉为与Yahoo, Amazon, eBay,AOL比肩的五大互联网商务流派代表之一。全球互联网流量监测网站Alexa.com对全球商务及贸易类网站进行排名调查,阿里巴巴网站排名首位。调查显示:阿里巴巴的网上会员近五成是通过口碑相传得知阿里巴巴并使用阿里巴巴;各行业会员通过阿里巴巴商务平台双方达成合作者占总会员比率近五成。</p>
                        </div>

                        <div class="author-box">
                            <div class="media">
                                <!-- <img src="images/dummy-img-300x300.jpg" alt="" class="img-fluid"> -->
                                <img src="images/eb9849ba221467982e56799d97a39ba6_马云.jpg.png" alt="" class="img-fluid">
                            </div>
                            <div class="body">
                                <h4 class="media-heading"><span>董事局主席 :</span>马云</h4>
                                马云为阿里巴巴集团主要创始人，于2013年5月出任董事局主席。自1999年阿里巴巴集团成立以来直至2013年5月，马云一直担任董事局主席及首席执行官。他同时是浙江马云公益基金会创立者。马云现担任阿里巴巴集团的主要股东之一软银集团公司的董事，该公司为一家于东京证券交易所挂牌交易的公司。马云同时是世界经济论坛（WEF）基金会受託人委員會成員、浙商总会会长以及中国企业家俱乐部主席。
                              </div>
                              <div class="clearfix"></div>
                        </div>

                        <div class="single-page">
                            <Card :table="tableData"></Card>
                            <LineChart></LineChart>
                            <News :news_info="news" :notice_info="notice_info"></News>
                        </div>

                        <div class="single-page">

                            <div class="accordion rs-accordion" id="accordionExample">
                               <!-- Item 1 -->
                               <div class="card">
                                  <div class="card-header" id="headingOne">
                                     <h3 class="title">
                                        <button class="btn btn-link collapsed" type="button" data-toggle="collapse" data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                                        Exercitation ullamco laboris nisi
                                        </button>
                                     </h3>
                                  </div>
                                  <div id="collapseOne" class="collapse" aria-labelledby="headingOne" data-parent="#accordionExample">
                                     <div class="card-body">
                                        Create and publilsh dynamic websites for desktop, tablet, and mobile devices that meet the latest web standards- without writing code. Design freely using familiar tools and hundreds of web fonts. easily add interactivity, including slide shows, forms, and more.
                                     </div>
                                  </div>
                               </div>
                               <!-- Item 2 -->
                               <div class="card">
                                  <div class="card-header" id="headingTwo">
                                     <h3 class="title">
                                        <button class="btn btn-link collapsed" type="button" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                                        Excepteur sintoccaecat cupidatat non proident
                                        </button>
                                     </h3>
                                  </div>
                                  <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionExample">
                                     <div class="card-body">
                                        Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt sapiente ea proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat craft beer farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard of them accusamus labore sustainable VHS.
                                     </div>
                                  </div>
                               </div>
                               <!-- Item 3 -->
                               <div class="card">
                                  <div class="card-header" id="headingThree">
                                     <h3 class="title">
                                        <button class="btn btn-link collapsed" type="button" data-toggle="collapse" data-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
                                        Officia deserunt mollit anim
                                        </button>
                                     </h3>
                                  </div>
                                  <div id="collapseThree" class="collapse" aria-labelledby="headingThree" data-parent="#accordionExample">
                                     <div class="card-body">
                                        <p>Unzip the file, locate Html file and double click the file and you will directly to adobe Html. Next step you can modifications our template, you can customize color, text, font, content, logo and image with your need using familiar tools on adobe Html without writing any code.</p>
                                        <p>You can't re-distribute the Item as stock, in a tool or template, or with source files. You can't re-distribute or make available the Item as-is or with superficial modifications. These things are not allowed even if the re-distribution is for Free.</p>
                                     </div>
                                  </div>
                               </div>
                               <!-- Item 4 -->
                               <div class="card">
                                  <div class="card-header" id="headingFour">
                                     <h3 class="title">
                                        <button class="btn btn-link collapsed" type="button" data-toggle="collapse" data-target="#collapseFour" aria-expanded="false" aria-controls="collapseFour">
                                        Utenim ad minim veniam
                                        </button>
                                     </h3>
                                  </div>
                                  <div id="collapseFour" class="collapse" aria-labelledby="headingFour" data-parent="#accordionExample">
                                     <div class="card-body">
                                        <p>Unzip the file, locate Html file and double click the file and you will directly to adobe Html. Next step you can modifications our template, you can customize color, text, font, content, logo and image with your need using familiar tools on adobe Html without writing any code.</p>
                                        <p>You can't re-distribute the Item as stock, in a tool or template, or with source files. You can't re-distribute or make available the Item as-is or with superficial modifications. These things are not allowed even if the re-distribution is for Free.</p>
                                     </div>
                                  </div>
                               </div>
                               <!-- Item 5 -->
                               <div class="card">
                                  <div class="card-header" id="headingFive">
                                     <h3 class="title">
                                        <button class="btn btn-link collapsed" type="button" data-toggle="collapse" data-target="#collapseFive" aria-expanded="false" aria-controls="collapseFive">
                                        Dolore magna aliqua
                                        </button>
                                     </h3>
                                  </div>
                                  <div id="collapseFive" class="collapse" aria-labelledby="headingFive" data-parent="#accordionExample">
                                     <div class="card-body">
                                        <p>Unzip the file, locate Html file and double click the file and you will directly to adobe Html. Next step you can modifications our template, you can customize color, text, font, content, logo and image with your need using familiar tools on adobe Html without writing any code.</p>
                                        <p>You can't re-distribute the Item as stock, in a tool or template, or with source files. You can't re-distribute or make available the Item as-is or with superficial modifications. These things are not allowed even if the re-distribution is for Free.</p>
                                     </div>
                                  </div>
                               </div>
                            </div>
                            <!-- end accordion -->

                            <p class="mt-2"><em>* Veniam quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat consectetur adipiscing elit tellus luctus nec ullamcorper mattis.</em></p>

                        </div>

                        <div class="single-news">
                            <!-- <div class="media-box">
                                <a href="page-news-single.html">
                                    <img src="images/dummy-img-1920x1280.jpg" alt="" class="img-fluid">
                                </a>
                            </div> -->
                            <h2 class="title">Ut enim ad minim veniam</h2>
                            <div class="meta mb-4">

                                <div class="meta-date d-inline"><i class="fa fa-clock-o"></i> May 12, 2017</div> <div class="meta-author d-inline">Posted by Rome Doel</div>
                            </div>

                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
                            <blockquote>Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
                            <footer>Carol Mongol</footer></blockquote>
                            <div class="margin-bottom-50"></div>
                            <p><strong>Ut enim ad minim veniam</strong></p>
                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
                        </div>
                        <!-- end single blog -->

                    </div>

                    <div class="col-sm-12 col-md-12 col-lg-4 pleft">

                        <div class="widget widget-text">
                            <div class="widget-title">
                                联系方式 <span>Contact</span>
                            </div>
                            <div class="row mb-3">
                                <div class="col-4">Address :</div>
                                <div class="col-8">99 Park Jomblo Street, Panam, Pekanbaru 28292, Riau</div>
                            </div>
                            <div class="row mb-3">
                                <div class="col-4">Office  :</div>
                                <div class="col-8">(123) 65412309</div>
                            </div>
                            <div class="row mb-3">
                                <div class="col-4">Fax :</div>
                                <div class="col-8">(123) 65412309</div>
                            </div>
                            <div class="row mb-3">
                                <div class="col-4">Email :</div>
                                <div class="col-8">info@yoursite.com</div>
                            </div>

                        </div>

                        <div class="widget widget-text">
                            <div class="widget-title">
                                新闻动态 <span>News</span>
                            </div>
                            <div class="latest-post-item">
                                <div class="meta-date"><span>30</span>May</div>
                                <div class="title"><a href="page-news-single.html">Deserunt mollit anim id est laborum</a></div>
                                <p class="meta-author">Posted by Rome Doel</p>
                            </div>
                            <div class="latest-post-item">
                                <div class="meta-date"><span>02</span>Des</div>
                                <div class="title"><a href="page-news-single.html">Occaecat cupidatat non proident</a></div>
                                <p class="meta-author">Posted by Rome Doel</p>
                            </div>
                            <div class="latest-post-item">
                                <div class="meta-date"><span>14</span>Feb</div>
                                <div class="title"><a href="page-news-single.html">Duis aute irure dolor in reprehenderit in voluptate velit</a></div>
                                <p class="meta-author">Posted by Rome Doel</p>
                            </div>

                        </div>

                        <div class="widget info-detail">
                            <h4 class="section-heading text-black no-after mb-3">
                                Download <span class="text-primary">Brochure</span>
                            </h4>
                            <div class="widget download">
                                <ul class="category-nav">
                                    <li><a href="#" class="btn btn-secondary btn-block btn-sidebar"><span class="fas fa-file-pdf mr-3"></span> Company Profile</a></li>
                                    <li><a href="#" class="btn btn-secondary btn-block btn-sidebar"><span class="fas fa-file-pdf mr-3"></span> Product Knowledge</a></li>
                                    <li><a href="#" class="btn btn-secondary btn-block btn-sidebar"><span class="fas fa-file-pdf mr-3"></span> Voluptate Velit</a></li>
                                </ul>
                            </div>
                        </div>

                        <div class="widget categories">
                            <ul class="category-nav">
                                <li class="active"><a href="#" title="Landscape Design">Voluptate Velit</a></li>
                                <li><a href="#" title="Planting & Removal">Fugiat Pariatur</a></li>
                                <li><a href="#" title="Garden Care">Excepteur Sint</a></li>
                                <li><a href="#" title="Irrigation & Drainage">Exercitation</a></li>
                                <li><a href="#" title="Stone and Hardscaping">Minim Veniam</a></li>
                                <li><a href="#" title="Rubbish Removal">Nulla Pariatur</a></li>
                            </ul>
                        </div>

                        <div class="widget widget-text">
                            <div class="widget-title">
                                Download <span>Brochure</span>
                            </div>

                            <p>Nam efficitur orci quis leo tincidunt, ac lacinia purus aliquet. Nam pellentesque pretium nibh cursus diam dapibus a.</p>
                            <a href="#" class="btn btn-primary">Download Now</a>
                        </div>

                        <div class="widget widget-text">
                            <div class="widget-title">
                                Text <span>Widget</span>
                            </div>
                            <p>Induse is designed for industrial, oil and gas, manufacturing, mechanical, power and energy, engineering & Multipurpose Business. This template has beautifull and unique design that will be best suited for your online web presence. It has 100% responsive design and tested on all major handheld devices.</p>
                            <p>Nam efficitur orci quis leo tincidunt, ac lacinia purus aliquet. Nam pellentesque pretium nibh cursus diam dapibus a.</p>
                        </div>

                        <div class="widget widget-archive">
                            <div class="widget-title">
                                Archive
                            </div>
                            <select class="form-control">
                                <option>April 2017</option>
                                <option>March 2017</option>
                                <option>February 2017</option>
                                <option>January 2017</option>
                            </select>
                        </div>

                        <div class="widget tags">
                            <div class="widget-title">
                                Tags
                            </div>
                            <div class="tagcloud">
                                <a href="#" title="3 topics">business</a>
                                <a href="#" title="1 topic" >advocate</a>
                                <a href="#" title="1 topic" >attorney</a>
                                <a href="#" title="4 topics" >consult</a>
                                <a href="#" title="2 topics" >consultant</a>
                                <a href="#" title="1 topic" >corporate</a>
                                <a href="#" title="2 topics" >consulting</a>
                                <a href="#" title="1 topic" >government</a>
                                <a href="#" title="2 topics" >justice</a>
                                <a href="#" title="5 topics">law</a>
                                <a href="#" title="2 topics">lawyers</a>
                                <a href="#" title="1 topic" >legal</a>
                            </div>
                        </div>

                    </div>

                </div>
            </div>
        </div>
    </div>

    <!-- CTA -->
    <div class="section bg-primary">
        <div class="content-wrap py-5">
            <div class="container">

                <div class="row align-items-center cta-block-1">
                    <div class="col-sm-8 col-md-8">
                        <h4 class="my-1 text-black">Don't hesitate to contact us any time</h4>
                    </div>

                    <div class="col-sm-4 col-md-4">
                        <div class="tbutton"><a href="#" class="btn btn-secondary">Get a Quote</a></div>
                    </div>

                </div>

            </div>
        </div>
    </div>

    <!-- FOOTER SECTION -->
    <div class="footer">
        <div class="content-wrap">
            <div class="container">

                <div class="row">

                    <div class="col-sm-6 col-md-6 col-lg-4">
                        <div class="footer-item">
                            <img src="images/logo-light.png" alt="logo bottom" class="logo-bottom">
                            <div class="spacer-30"></div>
                            <p>Nam eu laoreet dui, quis aliquet neque. Phasellus accumsan nibh nibh, sit amet vehicula mauris porta quis.</p>

                            <ul class="list-info my-4">
                                <li>
                                    <div class="info-icon uk21">
                                        <span class="fas fa-phone-alt"></span>
                                    </div>
                                    <div class="info-text uk21"><strong>+62-123 014 6789</strong></div>
                                </li>
                            </ul>

                            <div class="sosmed-icon d-inline-flex">
                                <a href="#"><i class="fab fa-facebook"></i></a>
                                <a href="#"><i class="fab fa-twitter"></i></a>
                                <a href="#"><i class="fab fa-instagram"></i></a>
                                <a href="#"><i class="fab fa-linkedin"></i></a>
                            </div>
                        </div>
                    </div>

                    <div class="col-sm-6 col-md-6 col-lg-4">
                        <div class="footer-item">
                            <div class="footer-title">
                                Additional Menu
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <ul class="list">
                                        <li><a href="#" title="Home">Home</a></li>
                                        <li><a href="#" title="Pages">Pages</a></li>
                                        <li><a href="#" title="Blog">Blog</a></li>
                                        <li><a href="#" title="Contact">Contact</a></li>
                                    </ul>
                                </div>
                                <div class="col-md-6">
                                    <ul class="list">
                                        <li><a href="#" title="My Account">My Account</a></li>
                                        <li><a href="#" title="Help Desk">Help Desk</a></li>
                                        <li><a href="#" title="Support">Support</a></li>
                                        <li><a href="#" title="Your Order">Your Order</a></li>
                                    </ul>
                                </div>
                            </div>

                        </div>
                    </div>

                    <div class="col-sm-6 col-md-6 col-lg-4">
                        <div class="footer-item">
                            <div class="footer-title">
                                Get a Newslatter
                            </div>

                            <p>Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.</p>

                        </div>
                    </div>

                </div>

            </div>
        </div>
        <div class="fcopy">
            <div class="container">
                <div class="row">
                    <div class="col-sm-12 col-md-12 col-lg-12">
                        <p class="mt-3 text-center">Copyright 2020 Subsco HTML Template – All rights reserved.</p>
                    </div>
                </div>
            </div>
        </div>

    </div>

  </div>

</template>

<script src="../../public/js/vendor/modernizr.min.js"></script>
<!-- JS VENDOR -->
<!--script src="../../public/js/vendor/jquery.min.js"></script-->
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="../../public/js/vendor/bootstrap.min.js"></script>
<script>$('.collapse').collapse()</script>
<script src="../../public/js/vendor/owl.carousel.js"></script>
<script src="../../public/js/vendor/jquery.magnific-popup.min.js"></script>
<!-- SENDMAIL -->
<script src="../../public/js/vendor/validator.min.js"></script>
<script src="../../public/js/vendor/form-scripts.js"></script>
<script src="../../public/js/script.js"></script>

<script>
// @ is an alias to /src
import Card from '../components/Card.vue'
import News from '../components/News.vue'
import LineChart from '../components/LineChart'

export default {
  name: 'Detail',
  components: {
    Card,
    News,
    LineChart
  },
  data() {
      return {
          stockCode:decodeURI(this.$route.query.stockCode),
          detailInfo:{},
          companyInfo: {},
          notice_info: [],
          news: [],
          tableData: []
      };
  },
  created() {
      console.log(this.stockCode);
      this.getData();
  },
  methods: {
    async getData () {
            let {data} = await this.$get(
                "http://121.46.19.26:8288/ForeSee/allInfo/" + this.stockCode
            )
            // let  {data}  = await this.$get("/data/page3_expect.json");
            this.detailInfo = data
            this.companyInfo = data.companyInfo
            this.news = data.news
            this.notice_info = data.notice_info
            this.tableData = data.tableData
        }
  }
}
</script>

<style src="../../public/css/vendor/bootstrap.min.css"></style>
<style src="../../public/css/vendor/owl.carousel.min.css"></style>
<style src="../../public/css/vendor/owl.theme.default.min.css"></style>
<style src="../../public/css/vendor/magnific-popup.css"></style>
<style src="../../public/css/vendor/animate.min.css"></style>
<style src="../../public/css/fontawesome.css"></style>
<style src="../../public/css/brands.css"></style>
<style src="../../public/css/solid.css"></style>
<style src="../../public/css/style.css"></style>
