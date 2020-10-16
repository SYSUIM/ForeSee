<template>
    <div id="home" class="banner">
    	<div class="owl-carousel owl-theme full-screen">
	    	<div class="item">
	        	<!--img src="images/dummy-img-1200x800.jpg" alt="Slider"-->
	        	<div class="overlay-bg"></div> 
	        	<div class="container d-flex align-items-center h-center">
	            	<div class="wrap-caption">
		                <h1 class="caption-heading text-white">Engineering your dreams with us</h1>
		                <input type="text" class="search keyword" placeholder="Search Company" v-model="input" @keyup.enter="trans" />
		                <button class="btn btn-primary" type="button" @click="trans">Search</button> 
		                <!--a href="#" class="btn btn-secondary">Contact Us</a-->
		            </div>   
	            </div>
	    	</div>
    	</div>
	   
    </div>
</template>

<script>
export default {
  data() {
    return {
      input: ""
    };
  },
  methods: {
    trans() {
      setTimeout(() => {
        this.$router.push("/about" + "?query=" + this.input);
      }, 200);
    }
  }
};
</script>

<style scoped>
@import "../assets/css/style.css"; 
@import "../assets/css/vendor/bootstrap.min.css";  
@import "../assets/css/vendor/owl.carousel.min.css"; 
@import "../assets/css/vendor/owl.theme.default.min.css"; 
@import "../assets/css/vendor/magnific-popup.css"; 
@import "../assets/css/vendor/animate.min.css"; 
@import "../assets/css/fontawesome.css"; 
@import "../assets/css/brands.css"; 
@import "../assets/css/solid.css"; 
 </style>
