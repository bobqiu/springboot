var dom_
#
instance_id
#
= document.getElementById("heatmap_#instance_id#");
var myChart_
#
instance_id
#
= echarts.init(dom_
#
instance_id
#)
;
var app_
#
instance_id
#
= {};
option_
#
instance_id
#
= null;
app_
#
instance_id
#.
title = '机票话量热力图';

var hours_
#
instance_id
#
= ['12a', '1a', '2a', '3a', '4a', '5a', '6a',
    '7a', '8a', '9a', '10a', '11a',
    '12p', '1p', '2p', '3p', '4p', '5p',
    '6p', '7p', '8p', '9p', '10p', '11p'];
var days_
#
instance_id
#
= ['Saturday', 'Friday', 'Thursday',
    'Wednesday', 'Tuesday', 'Monday', 'Sunday'];


var data = [[${data}]];

data = data.map(function (item) {
    return [item[1], item[0], item[2] || '-'];
});

option_
#
instance_id
#
= {
    title: {
        text: '机票周话量热力图',
        left: 'center'
    },
    tooltip: {
        position: 'top'
    },
    animation: false,
    grid: {
        height: '50%',
        y: '10%'
    },
    xAxis: {
        type: 'category',
        data: hours_
#
instance_id
#,
splitArea: {
    show: true
}
},
yAxis: {
    type: 'category',
        data
:
    days_#instance_id#,
    splitArea: {
        show: true
    }
}
,
visualMap: {
    min: 0,
        max
:
    10,
        calculable
:
    true,
        orient
:
    'horizontal',
        left
:
    'center',
        bottom
:
    '15%'
}
,
series: [{
    name: 'Punch Card',
    type: 'heatmap',
    data: data,
    label: {
        normal: {
            show: true
        }
    },
    itemStyle: {
        emphasis: {
            shadowBlur: 10,
            shadowColor: 'rgba(0, 0, 0, 0.5)'
        }
    }
}]
}
;

if (option_#
instance_id
# &&
typeof option_
#
instance_id
# ===
"object"
)
{
    myChart_#instance_id#.
    setOption(option_#instance_id#,
    true
)
    ;
}
;