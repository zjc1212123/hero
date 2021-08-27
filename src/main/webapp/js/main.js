//表单序列化JSON
$.fn.serializeJSON = function () {
    //初始化json对象
    var jsonObj = {};
    //将表单元素序列化为数组
    var array = this.serializeArray();
    //遍历数组，将每个数组元素的name作为json对象的键，value做为json对象的值
    for (var i = 0; i < array.length; i++) {
        jsonObj[array[i].name] = array[i].value;
    }
    //返回json对象
    return jsonObj;
}