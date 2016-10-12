var dom = document.getElementById("mapall");
var myChart = echarts.init(dom);
var app = {};
option = null;
function randomData() {
    return Math.round(Math.random() * 1000);
}

option = {
    title: {
        text: '机票订购用户全国分布图',
        left: 'center'
    },
    tooltip: {
        trigger: 'item',
        formatter: "{b} : {c}"
    },
    visualMap: {
        min: 0,
        max: 400000,
        left: 'left',
        top: 'bottom',
        text: ['高', '低'],           // 文本，默认为数值文本
        calculable: true
    },
    toolbox: {
        show: true,
        orient: 'vertical',
        left: 'right',
        top: 'center',
        feature: {
            dataView: {readOnly: false},
            restore: {},
            saveAsImage: {}
        }
    },
    series: [
        {
            type: 'map',
            mapType: 'china',
            label: {
                normal: {
                    show: true
                },
                emphasis: {
                    show: true
                }
            },
            data: [
                {name: '北京', value: 150002},
                {name: '天津', value: 42444},
                {name: '上海', value: 55341},
                {name: '重庆', value: 84536},
                {name: '河北', value: 227749},
                {name: '河南', value: 494121},
                {name: '云南', value: 152950},
                {name: '辽宁', value: 167028},
                {name: '黑龙江', value: 211377},
                {name: '湖南', value: 376842},
                {name: '安徽', value: 268448},
                {name: '山东', value: 171169},
                {name: '新疆', value: 138856},
                {name: '江苏', value: 478459},
                {name: '浙江', value: 466431},
                {name: '江西', value: 280360},
                {name: '湖北', value: 356740},
                {name: '广西', value: 166377},
                {name: '甘肃', value: 115771},
                {name: '山西', value: 146431},
                {name: '内蒙古', value: 238191},
                {name: '陕西', value: 341055},
                {name: '吉林', value: 123306},
                {name: '福建', value: 507022},
                {name: '贵州', value: 204798},
                {name: '广东', value: 460213},
                {name: '青海', value: 42081},
                {name: '西藏', value: 7760},
                {name: '四川', value: 816884},
                {name: '宁夏', value: 38891},
                {name: '海南', value: 49377},
                {name: '台湾', value: 0},
                {name: '香港', value: 0},
                {name: '澳门', value: 0}
            ]
        }
    ]
};
;
if (option && typeof option === "object") {
    myChart.setOption(option, true);
}