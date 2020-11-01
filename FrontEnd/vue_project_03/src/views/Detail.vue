<template>
  <div data-spy="scroll" data-target="#navbar-example">

    <!-- LOAD PAGE -->
    <div class="animationload">
        <div class="loader"></div>
    </div>

    <!-- BACK TO TOP SECTION -->
    <a href="#0" class="cd-top cd-is-visible cd-fade-out">Top</a>

    <Header></Header>

    <!-- BANNER -->
    <div class="section banner-page" data-background="../assets/images/banner-bg.png">
        <div class="content-wrap pos-relative">
            <div class="container">
                <div class="col-12 col-md-12">
                    <div class="d-flex bd-highlight mb-2">
                        <div class="title-page" :data="companyInfo">{{ companyInfo.companyName }}</div>
                    </div>
                    <nav aria-label="breadcrumb">
                      <ol class="breadcrumb ">
                        <li class="breadcrumb-item" :data="companyInfo">股票代码：{{ companyInfo.stockCode }}</li>
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
                            <!-- <h4 class="text-black uk21">
                                简介<span>Contact</span>
                            </h4> -->
                            <div class="widget-title">
                                公司简介 <span>Introduction</span>
                            </div>
                        </div>
                        <p class="introduction" v-show="flag" :data="describe_arr">{{ describe_arr }}
                            <a href="javascript:void(0)" @click="toggle" class="toggle">展开</a>
                        </p>
                        <p class="introduction" v-show="!flag" :data="companyInfo">{{ companyInfo.describe }}
                            <a href="javascript:void(0)" @click="toggle" class="toggle">收起</a>
                        </p>

                        <div class="single-page">
                            <Card :table="tableData"></Card>
                            <LineChart :jsonObj="profit"></LineChart>
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
                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
                        </div>
                        <!-- end single blog -->

                    </div>

                    <div class="col-sm-12 col-md-12 col-lg-4 pleft">

                        <div class="widget widget-text" :data="contact">
                            <div class="widget-title">
                                联系方式 <span>Contact</span>
                            </div>
                            <div class="row mb-3">
                                <div class="col-4">地址 :</div>
                                <div class="col-8">{{ contact.address }}</div>
                            </div>
                            <div class="row mb-3">
                                <div class="col-4">办公室  :</div>
                                <div class="col-8">{{ contact.office }}</div>
                            </div>
                            <div class="row mb-3">
                                <div class="col-4">传真 :</div>
                                <div class="col-8">{{ contact.fax }}</div>
                            </div>
                            <div class="row mb-3">
                                <div class="col-4">邮箱 :</div>
                                <div class="col-8">{{ contact.email }}</div>
                            </div>

                        </div>

                        <div class="widget widget-text">
                            <div class="widget-title">
                                企业地图 <span>Map</span>
                            </div>
                            <GeoSingle></GeoSingle>

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

    <CTA></CTA>

    <!-- FOOTER SECTION -->
    <Footer></Footer>

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
import Header from "@/components/Header";
import Footer from "@/components/Footer";
import CTA from "@/components/CTA";
import Card from '../components/Card.vue';
import News from '../components/News.vue';
import LineChart from '../components/LineChart';
import GeoSingle from '../components/GeoSingle';

export default {
  name: 'Detail',
  components: {
    Header,
    Footer,
    CTA,
    Card,
    News,
    LineChart,
    GeoSingle
  },
  data() {
      return {
          stockCode:decodeURI(this.$route.query.stockCode),
          companyInfo: {},    //公司基本详情，包括名称、股票代码、简介等
          notice_info: [],    //公告
          news: [],           //新闻
          tableData: [],      //表格
          profit: {},         //营收折线图
          contact: {},        //企业联系方式
          describe_arr: "",   //缩略版的企业简介
          flag: true          //配合 toggle 方法，用于控制企业简介的展开与折叠
      };
  },
  created() {
      //console.log(this.stockCode);
      this.getData();
  },
  methods: {
    async getData () {
            // let {data} = await this.$get(
            //     "http://121.46.19.26:8288/ForeSee/allInfo/" + this.stockCode
            // )
            let  {data}  = await this.$get("/data/page3_expect.json");
            this.companyInfo = data.companyInfo
            this.news = data.news
            this.notice_info = data.notice_info
            this.tableData = data.tableData
            this.contact = data.contact
            this.describe_arr = data.companyInfo.describe.slice(0,120) + "..."
            this.profit = data.profit
        },
    toggle () {
        //变换 flag, 用于控制企业简介的展开与折叠
        this.flag = !this.flag
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
<style>
.banner-page:before {
  background-image: url('../assets/images/banner-bg.png');
  opacity: 1.0;
}
.introduction {
    font-size: 16px;
    text-indent: 0em;
}
.introduction::first-letter {
    font-size: 30px;
    color: #FFD808; 
    float: left;
}
.toggle {
    color: #FFD808;
}

</style>
