// 百度地图API功能
var map = new BMap.Map("map");          // 创建地图实例
var point = new BMap.Point(116.403694, 39.927552);  // 创建点坐标
map.centerAndZoom(point, 12);                 // 初始化地图，设置中心点坐标和地图级别
map.enableScrollWheelZoom();
map.addControl(new BMap.NavigationControl());  //添加默认缩放平移控件
map.addControl(new BMap.MapTypeControl());   //添加地图类型控件


// 覆盖区域图层测试
map.addTileLayer(new BMap.PanoramaCoverageLayer());

var stCtrl = new BMap.PanoramaControl(); //构造全景控件
stCtrl.setOffset(new BMap.Size(10, 60));
map.addControl(stCtrl);//添加全景控件

//给地图添加右键菜单

var menu = new BMap.ContextMenu();
var txtMenuItem = [

    {
        text: '人群触达',
        callback: function () {
            fn()
        }
    },
    {
        text: '人群透视',
        callback: function () {
            pagetz1()
        }
    },
    {
        text: '人群营销',
        callback: function () {
            pagetz()
        }
    }
];
for (var i = 0; i < txtMenuItem.length; i++) {
    menu.addItem(new BMap.MenuItem(txtMenuItem[i].text, txtMenuItem[i].callback, 100));
}
map.addContextMenu(menu);

//人群营销页面跳转
function pagetz() {
    window.location.href = "newmarketing.html";
}
//人群透视界面跳转
function pagetz1() {
    window.location.href = "action.html";
}

//短信触达窗口弹出

function fn() {
    document.getElementById("yin").click();
}

//绘制圆形区域


//路况提示功能
var ctrl = new BMapLib.TrafficControl({
    showPanel: false //是否显示路况提示面板
});
map.addControl(ctrl);
ctrl.setAnchor(BMAP_ANCHOR_BOTTOM_RIGHT);

//初始化模板选择的下拉框
var sel = document.getElementById('stylelist');
for (var key in mapstyles) {
    var style = mapstyles[key];
    var item = new Option(style.title, key);
    sel.options.add(item);
}

window.map = map;
changeMapStyle('normal')
sel.value = 'normal';

function changeMapStyle(style) {
    map.setMapStyle({style: style});
    $('#desc').html(mapstyles[style].desc);
}

// 用经纬度设置地图中心点
function theLocation() {
    if (document.getElementById("longitude").value != "" && document.getElementById("latitude").value != "") {
        map.clearOverlays();
        var new_point = new BMap.Point(document.getElementById("longitude").value, document.getElementById("latitude").value);
        var marker = new BMap.Marker(new_point);  // 创建标注
        map.addOverlay(marker);              // 将标注添加到地图中
        map.panTo(new_point);
    }
}

//麻点图层
var customLayer;
function addCustomLayer(keyword) {
    if (customLayer) {
        map.removeTileLayer(customLayer);
    }
    customLayer = new BMap.CustomLayer({
        geotableId: 30960,
        q: '', //检索关键字
        tags: '', //空格分隔的多字符串
        filter: '' //过滤条件,参考http://developer.baidu.com/map/lbs-geosearch.htm#.search.nearby
    });
    map.addTileLayer(customLayer);
    customLayer.addEventListener('hotspotclick', callback);
}
function callback(e)//单击热点图层
{
    var customPoi = e.customPoi;//poi的默认字段
    var contentPoi = e.content;//poi的自定义字段
    var content = '<p style="width:280px;margin:0;line-height:20px;">地址：' + customPoi.address + '<br/>价格:' + contentPoi.dayprice + '元' + '</p>';
    var searchInfoWindow = new BMapLib.SearchInfoWindow(map, content, {
        title: customPoi.title, //标题
        width: 290, //宽度
        height: 100, //高度
        panel: "panel", //检索结果面板
        enableAutoPan: true, //自动平移
        enableSendToPhone: true, //是否显示发送到手机按钮
        searchTypes: [
            BMAPLIB_TAB_SEARCH,   //周边检索
            BMAPLIB_TAB_TO_HERE,  //到这里去
            BMAPLIB_TAB_FROM_HERE //从这里出发
        ]
    });
    var point = new BMap.Point(customPoi.point.lng, customPoi.point.lat);
    searchInfoWindow.open(point);
}
document.getElementById("open").onclick = function () {
    addCustomLayer();
};
document.getElementById("open").click();
document.getElementById("close").onclick = function () {
    if (customLayer) {
        map.removeTileLayer(customLayer);
    }
};


// 创建CityList对象，并放在citylist_container节点内
var myCl = new BMapLib.CityList({container: "citylist_container", map: map});

// 给城市点击时，添加相关操作
myCl.addEventListener("cityclick", function (e) {
    // 修改当前城市显示
    document.getElementById("curCity").innerHTML = e.name;

    // 点击后隐藏城市列表
    document.getElementById("cityList").style.display = "none";
});
// 给“更换城市”链接添加点击操作
document.getElementById("curCityText").onclick = function () {
    var cl = document.getElementById("cityList");
    if (cl.style.display == "none") {
        cl.style.display = "";
    } else {
        cl.style.display = "none";
    }
};
// 给城市列表上的关闭按钮添加点击操作
document.getElementById("popup_close").onclick = function () {
    var cl = document.getElementById("cityList");
    if (cl.style.display == "none") {
        cl.style.display = "";
    } else {
        cl.style.display = "none";
    }
};
	
	