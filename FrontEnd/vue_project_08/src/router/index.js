import Vue from 'vue'
import VueRouter from 'vue-router'
Vue.use(VueRouter)



let router = new VueRouter({
    routes: [
        // {
        //     path: "/",
        //     component: () => import(/*webpackChunkName:"Home"*/'@/views/Home'),
        //     meta: { title: "首页" }
        // },
        {
            path: '/',
            name: 'Index',
            component: () => import(/* webpackChunkName: "Index" */ '@/views/Index'),
            meta: { title: "首页" }
        },
        {
            path: "/retrieval",
            props: true,
            component: () => import(/*webpackChunkName:"Retrieval"*/'@/views/Retrieval'),
            meta: { title: "企业检索" }
        },
        {
            path: "/detail",
            props: true,
            component: () => import(/*webpackChunkName:"Detail"*/'@/views/Detail'),
            meta: { title: "详情页" }
        },
        {
            path: "/industry",
            props: true,
            component: () => import(/*webpackChunkName:"industrial-report"*/'@/views/Industry'),
            meta: { title: "行业检索" }
        },
        {
            path: "/morenews",
            props: true,
            component: () => import(/*webpackChunkName:"MoreNews"*/'@/views/MoreNews'),
            meta: { title: "新闻" }
        },
        {
            path: "/morenotice",
            props: true,
            component: () => import(/*webpackChunkName:"MoreNews"*/'@/views/MoreNotice'),
            meta: { title: "公告" }
        },
        {
            path: "/industryrepo",
            props: true,
            component: () => import(/*webpackChunkName:"MoreNews"*/'@/views/IndustryReport'),
            meta: { title: "行业报告" }
        }
    ],
    scrollBehavior() {
        return { x: 0, y: 0 };
    },
})

router.beforeEach((to, from, next) => {
    // to and from are both route objects. must call `next`.
    if (to.meta.title)
        document.title = to.meta.title
    next()
})
export default router