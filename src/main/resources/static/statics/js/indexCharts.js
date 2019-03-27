/**
 *  网站防护折线图配置
 */
function wangzhan(data1,data2){
	var option = {
	    title: {
	        text: '网站防护'
	    },
	    tooltip : {
	        trigger: 'axis',
	        axisPointer: {
	            type: 'cross',
	            label: {
	                backgroundColor: '#6a7985'
	            }
	        }
	    },
	    legend: {
	        data:['文件总数','篡改数量']
	    },
	    grid: {
	        left: '3%',
	        right: '4%',
	        bottom: '3%',
	        containLabel: true
	    },
	    xAxis : [
	        {
	            type : 'category',
	            boundaryGap : false,
	            data : ['周一','周二','周三','周四','周五','周六','周日']
	        }
	    ],
	    yAxis : [
	        {
	            type : 'value'
	        }
	    ],
	    series : [
	        {
	            name:'文件总数',
	            type:'line',
	            stack: '总量',
	            areaStyle: {},
	            data:data1,
	            smooth: true
	        },
	        {
	            name:'篡改数量',
	            type:'line',
	            stack: '总量',
	            areaStyle: {},
	            data:data2,
	            smooth: true
	        }
	    ]
	};
	return option;
}


/**
 *  篡改事件折线图配置
 */
function shijian(data1,data2){
	var option = {
	    title: {
	        text: '篡改事件'
	    },
	    tooltip : {
	        trigger: 'axis',
	        axisPointer: {
	            type: 'cross',
	            label: {
	                backgroundColor: '#6a7985'
	            }
	        }
	    },
	    legend: {
	        data:['Windows','Linux']
	    },
	    grid: {
	        left: '3%',
	        right: '4%',
	        bottom: '3%',
	        containLabel: true
	    },
	    xAxis : [
	        {
	            type : 'category',
	            boundaryGap : false,
	            data : ['周一','周二','周三','周四','周五','周六','周日']
	        }
	    ],
	    yAxis : [
	        {
	            type : 'value'
	        }
	    ],
	    series : [
	        {
	            name:'Windows',
	            type:'line',
	            stack: '总量',
	            areaStyle: {},
	            data:data1,
	            smooth: true
	        },
	        {
	            name:'Linux',
	            type:'line',
	            stack: '总量',
	            areaStyle: {},
	            data:data2,
	            smooth: true
	        }
	    ]
	};
	return option;
}

/**
 *  站点访问折线图配置
 */
function website(data1,data2){
	var colors = ['#5793f3', '#d14a61', '#675bba'];
	option = {
	    color: colors,
	    title: {
	        text: '网站访问'
	    },
	    tooltip: {
	    	trigger: 'axis',
	        axisPointer: {
	            type: 'cross',
	            label: {
	                backgroundColor: '#6a7985'
	            }
	        }
	    },
	    legend: {
	        data:['PV', 'IP']
	    },
	    grid: {
	        left: '3%',
	        right: '4%',
	        bottom: '3%',
	        containLabel: true
	    },
	    xAxis: [
	    	{
	            type : 'category',
	            boundaryGap : false,
	            data : ['周一','周二','周三','周四','周五','周六','周日']
	        }
	    ],
	    yAxis: [
	        {
	            type: 'value'
	        }
	    ],
	    series: [
	        {
	            name:'PV',
	            type:'line',
	            smooth: true,
	            data: data1
	        },
	        {
	            name:'IP',
	            type:'line',
	            smooth: true,
	            data: data2
	        }
	    ]
	};

	return option;
}

function liuliang(data1){
	var option = {
		color:'#009688',
	    tooltip: {
	    	trigger: 'axis',
	        axisPointer: {
	            type: 'cross',
	            label: {
	                backgroundColor: '#6a7985'
	            }
	        }
	    },
	    grid: {
	        left: '3%',
	        right: '4%',
	        bottom: '3%',
	        height: '90%',
	        containLabel: true
	    },
	    xAxis: {
	        type: 'category',
	        data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
	    },
	    yAxis: {
	        type: 'value'
	    },
	    series: [{
	        data: data1,
	        type: 'bar'
	    }]
	};
	return option;

}
