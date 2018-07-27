<#macro subString value size>
	<#if value?length gt size>
		${value?substring(0,16)}...
	<#else>
		${value}
	</#if>		
</#macro>

<#macro replaceName value>
	<#if value?length gt 1>
		<#assign a = value?length-1>
		<#list 1..a as b>*</#list>${value?substring(a)} 
	<#else>
		${value}
	</#if>		
</#macro>

<#macro showMobile value>
	<#if value?length = 11>
		${value?substring(0,3)}<#list 1..4 as b>*</#list>${value?substring(7,11)} 
	</#if>
</#macro>

<#macro showIdentity value>
	<#if value?length = 18>
		${value?substring(0,6)}<#list 1..8 as b>*</#list>${value?substring(14,18)}
	<#elseif value?length = 15>
		${value?substring(0,6)}<#list 1..6 as b>*</#list>${value?substring(12,15)} 
	</#if>
</#macro>

<#macro requiredTag>
	<em class="requiredTag">*</em>
</#macro>



<#--新分页-->
<#macro pagination page>
<div class="page">
       <#if (page.currentPage == 1)>
           <span class="first">首页</span>
           <span class="up">上一页</span>
       <#else>
           <a class="firstpage" title="首页" onclick="javascript:$.pageSkip(1);">首页</a>
           <a class="prepage" title="上一页" onclick="javascript:$.pageSkip(${page.currentPage-1});">上一页</a>
       </#if>

   <#if (page.totalPage == 1)>
        <a class="page_curr" onclick="javascript:$.pageSkip(1);">1</a>
    <#elseif (page.totalPage == 2)>
        <#assign class1 = "">
        <#assign class2 = "">
        <#if (page.currentPage == 1) >
                <#assign class1="page_curr" />
        </#if>
        <#if (page.currentPage == 2) >
            <#assign class2="page_curr" />
        </#if>
        <a class="${class1}" onclick="javascript:$.pageSkip(1);">1</a>
        <a class="${class2}" onclick="javascript:$.pageSkip(2);">2</a>
    <#elseif (page.totalPage == 3)>
       <#assign class1 = "">
       <#assign class2 = "">
       <#assign class3 = "">
       <#if (page.currentPage == 1) >
           <#assign class1="page_curr" />
       </#if>
       <#if (page.currentPage == 2) >
           <#assign class2="page_curr" />
       </#if>
       <#if (page.currentPage == 3) >
           <#assign class3="page_curr" />
       </#if>
        <a class="${class1}" onclick="javascript:$.pageSkip(1);">1</a>
        <a class="${class2}" onclick="javascript:$.pageSkip(2);">2</a>
        <a class="${class3}" onclick="javascript:$.pageSkip(3);">3</a>
   <#elseif (page.totalPage ==4)>
       <#assign class1 = "">
       <#assign class2 = "">
       <#assign class3 = "">
       <#assign class4 = "">
       <#if (page.currentPage == 1) >
           <#assign class1="page_curr" />
       </#if>
       <#if (page.currentPage == 2) >
           <#assign class2="page_curr" />
       </#if>
       <#if (page.currentPage == 3) >
           <#assign class3="page_curr" />
       </#if>
       <#if (page.currentPage == 4) >
           <#assign class4="page_curr" />
       </#if>
       <a class="${class1}" onclick="javascript:$.pageSkip(1);">1</a>
       <a class="${class2}" onclick="javascript:$.pageSkip(2);">2</a>
       <a class="${class3}" onclick="javascript:$.pageSkip(3);">3</a>
       <a class="${class4}" onclick="javascript:$.pageSkip(4);">4</a>
   <#else>
       <#if (page.currentPage == 1) >
           <a class="page_curr" onclick="javascript:$.pageSkip(${page.currentPage});">${page.currentPage}</a>
           <a onclick="javascript:$.pageSkip(${page.currentPage+1});">${page.currentPage+1}</a>
           <a onclick="javascript:$.pageSkip(${page.currentPage+2});">${page.currentPage+2}</a>
           <a onclick="javascript:$.pageSkip(${page.currentPage+3});">${page.currentPage+3}</a>
           <a onclick="javascript:$.pageSkip(${page.currentPage+4});">${page.currentPage+4}</a>
       </#if>
       <#if (page.currentPage == 2) >
           <a onclick="javascript:$.pageSkip(${page.currentPage-1});">${page.currentPage-1}</a>
           <a class="page_curr" onclick="javascript:$.pageSkip(${page.currentPage});">${page.currentPage}</a>
           <a onclick="javascript:$.pageSkip(${page.currentPage+1});">${page.currentPage+1}</a>
           <a onclick="javascript:$.pageSkip(${page.currentPage+2});">${page.currentPage+2}</a>
           <a onclick="javascript:$.pageSkip(${page.currentPage+3});">${page.currentPage+3}</a>

       </#if>
       <#if (page.currentPage >= 3) && (page.totalPage-page.currentPage >=2)>
           <a onclick="javascript:$.pageSkip(${page.currentPage-2});">${page.currentPage-2}</a>
           <a onclick="javascript:$.pageSkip(${page.currentPage-1});">${page.currentPage-1}</a>
           <a class="page_curr" onclick="javascript:$.pageSkip(${page.currentPage});">${page.currentPage}</a>
           <a onclick="javascript:$.pageSkip(${page.currentPage+1});">${page.currentPage+1}</a>
           <a onclick="javascript:$.pageSkip(${page.currentPage+2});">${page.currentPage+2}</a>
       </#if>
       <#if (page.currentPage >= 3) && (page.totalPage-page.currentPage ==1)>
           <a onclick="javascript:$.pageSkip(${page.currentPage-3});">${page.currentPage-3}</a>
           <a onclick="javascript:$.pageSkip(${page.currentPage-2});">${page.currentPage-2}</a>
           <a onclick="javascript:$.pageSkip(${page.currentPage-1});">${page.currentPage-1}</a>
           <a class="page_curr" onclick="javascript:$.pageSkip(${page.currentPage});">${page.currentPage}</a>
           <a onclick="javascript:$.pageSkip(${page.totalPage});">${page.totalPage}</a>
       </#if>
       <#if (page.currentPage >= 3) && (page.totalPage-page.currentPage ==0)>
           <a onclick="javascript:$.pageSkip(${page.currentPage-4});">${page.currentPage-4}</a>
           <a onclick="javascript:$.pageSkip(${page.currentPage-3});">${page.currentPage-3}</a>
           <a onclick="javascript:$.pageSkip(${page.currentPage-2});">${page.currentPage-2}</a>
           <a onclick="javascript:$.pageSkip(${page.currentPage-1});">${page.currentPage-1}</a>
           <a class="page_curr" onclick="javascript:$.pageSkip(${page.currentPage});">${page.currentPage}</a>
       </#if>

    </#if>


       <#if (page.currentPage == page.totalPage) >
           <span class="down">下一页</span>
           <span class="plist">尾页</span>
       <#else>
           <a class="prepage" title="下一页" onclick="javascript:$.pageSkip(${page.currentPage+1});">下一页</a>
           <a class="firstpage" title="尾页" onclick="javascript:$.pageSkip(${page.totalPage});">尾页</a>
       </#if>
    <span class="sum">共${page.totalResult}条  当前${page.currentPage}/${page.totalPage}页</span>
    <input id="currentPage" name="currentPage" size="3" value="${page.currentPage}" maxlength="9" onpaste="return false;" class="pager">
    <input type="submit" value="确认" class="btn_bule btn_b_mini"  ">
</div>
</#macro>

<#--部门联动-->
<#macro formDeptSelect formSelects parameters>
    <#assign id = parameters.id />
<span id="formDeptSelect_${id}">
    <#list formSelects as formSelect>
        <#if (formSelect.firstOption)??>
            <#assign firstOption = ("<option value='"+formSelect.firstOption[0]+"'>"+formSelect.firstOption[1]+"</option>") />
        <#else>
            <#assign firstOption = "">
        </#if>
        <#assign selectid = formSelect.id />
        <#if selectid == "">
            <#assign selectid = formSelect.name>
        </#if>
        <#if (formSelect.selectName)??>
            <label>${formSelect.selectName}</label>
        </#if>
        <select name="${formSelect.name}" id="${selectid}" ${formSelect.attributes}>
        ${firstOption}
        </select>
    </#list>
</span>
<script type="text/javascript">
    jQuery(function(){
    <#--select集合-->
        var selects = jQuery('select',jQuery('#formDeptSelect_${id}'));
    <#--选中值数组-->
        var selectedValues = [<#list formSelects as formSelect><#if formSelect_index gt 0>,</#if>'${formSelect.selectedValue}'</#list>];
    <#--首选项数组-->
        var firstOption = [<#list formSelects as formSelect><#if (formSelect.firstOption)??><#if formSelect_index gt 0>,</#if>'<option value="${(formSelect.firstOption)[0]}">${(formSelect.firstOption)[1]}</option>'</#if></#list>];
        jQuery.post(
                '${base}/system/dept/getDeptByParentCode',
                {'parentId':'1000'},
                function(responseText, textStatus){
                    responseText = decodeURIComponent(responseText,"UTF-8");
                    if(jQuery.trim(responseText) != ''){
                        jQuery(selects.get(0)).append(responseText);
                        if(jQuery.trim(selectedValues[0])!=''){<#--选中的值-->
                            setTimeout(function() {
                                jQuery(selects.get(0)).val(selectedValues[0]);<#--定位-->
                            });
                            appendChildSelect(1);<#--加载下属select的options-->
                        }
                    }
                }
        );
        selects.each(function(i){<#--为每个select除最后一个,附加change事件-->
            if(i < selects.length - 1){ <#--去掉最后一个-->
                var selectNext = selects.get(i+1); <#--下一个-->
                jQuery(this).change(function(){
                    selects.each(function(j){ <#-- 将触发事件的select后面的select全部清空-->
                        if(j > i){
                            jQuery(this).empty().append(firstOption[i+1]);
                        }
                    })
                    if(this.value != ''){
                        jQuery.post(
                                '${base}/system/dept/getDeptByParentCode',
                                {'parentId':this.value},
                                function(responseText, textStatus){
                                    responseText = decodeURIComponent(responseText,"UTF-8");
                                    if(jQuery.trim(responseText) != ''){
                                        jQuery(selectNext).append(responseText);
                                    }
                                }
                        );
                    }
                })
            }
        });
    <#--加载下属select的options,递归-->
        function appendChildSelect(i){
            var select = selects.get(i);
            var parentValue = selectedValues[i-1];
            var thisValue = selectedValues[i];
            jQuery.post(
                    '${base}/system/dept/getDeptByParentCode',
                    {'parentId':parentValue},
                    function(responseText, textStatus){
                        responseText = decodeURIComponent(responseText,"UTF-8");
                        if(jQuery.trim(responseText) != ''){
                            jQuery(select).append(responseText);
                            if(jQuery.trim(thisValue)!=''){<#--选中的值-->
                                setTimeout(function() {
                                    jQuery(select).val(thisValue);
                                });
                                if(i < selectedValues.length - 1){<#--除去最后一个-->
                                    appendChildSelect(i+1);
                                }
                            }
                        }
                    }
            );
        }
    });
</script>
</#macro>


<#macro getDicData parameters>
	<#if parameters.data??>
		<#assign dictionaryData = parameters.data />
	<#else>
		<#assign dictionaryData = paramTool.queryByParentId('${parameters.parentId}') />
	</#if>
</#macro>

<#--下拉框-->
<#macro formSelect parameters attributes>
	<#assign id = parameters.id />
	<#if id == "">
		<#assign id = parameters.name />
	</#if>
	<@p.getDicData parameters />
	<select name="${parameters.name}" id="${id}" ${attributes!}>
		<#if (parameters.firstOption)??>
			<option value=${(parameters.firstOption)[0]}>${(parameters.firstOption)[1]}</option>
		</#if>
		<#list dictionaryData as option>
			<#assign selected = "">
			<#if parameters.selectedValue == option.parameterId>
				<#assign selected = 'selected' />	
			</#if>
			<option value=${option.parameterId} ${selected}>${option.parameterName}</option>
		</#list>
	</select>
</#macro>

<#--
   渲染一组 Radio标签
  $parameters {Map}包括
      name  {String} select 标签的name,必须
      dictGroup {String} 渲染数据字典的数据时，数据字典的分组
      data {List<DataDictionary>} 渲染的数据，dictGroup和data必须提供一个
      selectedValue 选择值
-->
<#macro formRadioList parameters>
	<#assign id = parameters.id />
	<#if id == "">
		<#assign id = parameters.name />
	</#if>
	<@p.getDicData parameters />	
	<div class="check_type">
	<#list dictionaryData as o>
	<#assign selected = '' />
	<#if parameters.selectedValue = o.parameterId>
		<#assign selected = 'checked' />
	<#elseif o_index==0>
		<#assign selected = 'checked' />
	</#if>
	    <label><input name="${parameters.name}" type="radio" id="${id}_${o.parameterId}" value="${o.parameterId}" ${selected} /><span>${o.parameterName}</span></label>
	</#list>
	</div>
</#macro>

<#--
   渲染一组 Checkbox标签
  $parameters {Map}包括
      name  {String} select 标签的name,必须
      dictGroup {String} 渲染数据字典的数据时，数据字典的分组
      data {List<FormOption>} 渲染的数据，dictGroup和data必须提供一个
      selectedValue 选择值,多个以","分割
-->
<#macro formCheckboxList parameters>
	<#assign id = parameters.id />
	<#if id == "">
		<#assign id = parameters.name />
	</#if>
	<@p.getDicData parameters />
	<#assign selectedValues = ',parameters.selectedValue,' />
	<#list dictionaryData as o>
		<#assign selected = '' />
		<#if selectedValues.indexOf(",o.value,") != "-1">
			<#assign selected = 'checked' />
		</#if>
		<input name="${parameters.name}" type="checkbox" id="${id}_${o.value}" value="${o.value}" ${selected}>
		$o.text
	</#list>
</#macro>

<#--展示参数名称-->
<#macro showParamName parameters>
	<@p.getDicData parameters />
	<#list dictionaryData as o>
		<#if o.parameterId = parameters.selectedValue>
			${o.parameterName}
		</#if>
	</#list>
</#macro>



<#macro getParamNameByCode code>
${paramTool.queryById('${code}').parameterName}
</#macro>


<#macro showMoney price currency>
	<#if price!=null && price!=''>
		<#if currency!='JPY'>
			${(price/100)?string('0.00')}
		<#else>
			${price?string('0')}
		</#if>
	<#else>
		<#if currency!='JPY'>
		0.00
		<#else>
		0
		</#if>
	</#if>
</#macro>

<#macro transferMoney price>
    <#if price!=null && price!=''>
        ${(price/100)?string('0')}
    <#else>
        0
    </#if>
</#macro>