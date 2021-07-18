# SubTileEntity

不建议玩家用这个类创建自定义花

这个类主要让代码方便维护

想创建产魔花请看 [SubTileGenerating](https://github.com/ikexing-cn/RandomTweaker/blob/master/wiki/zh_cn/modSupport/ContentTweaker/SubTileEntity/SubTileGenerating.md)

想创建功能花请看 [SubTileFunctional](https://github.com/ikexing-cn/RandomTweaker/blob/master/wiki/zh_cn/modSupport/ContentTweaker/SubTileEntity/SubTileFunctional.md)

## 导包

```zenscript
import mods.randomtweaker.cote.SubTileEntity;
```

## ZenProperty

| 字段 | 类型 | 描述 |
|:---- |:--- |----- |
| unlocalizedName | string | 注册 |
| range | int | 产魔范围 |
| color | int | 产魔花的颜色 |
| maxMana | int | 最大魔力容量 |
| acceptsRedstone | bool | 是否接受红石信号 |
| overgrowthAffected | bool | 是否受蕴魔土的影响 |

## ZenMethod

| 方法 | 类型 | 描述 |
|:---- |:--- |----- |
| register(typeName as string, subTileEntity as [SubTileEntity](https://github.com/ikexing-cn/RandomTweaker/blob/master/wiki/zh_cn/modSupport/ContentTweaker/SubTileEntity/SubTileEntity.md)) | void | 注册此自定义花 (同样, 玩家尽量不要使用这个方法注册自定义花) |

## 本地化

`tile.botania:flower.产魔花的名字.name` 本地化产魔花的名字

`tile.botania:flower.产魔花的名字.reference` 本地化产魔花的 tooltip

## 热重载

请安装 `ZenUtils` Mod

[事件热重载](https://github.com/friendlyhj/ZenUtils/wiki/ReloadEvents)
和 [CoT 函数热重载](https://github.com/friendlyhj/ZenUtils/wiki/LateSetCoTFunction) 都是此 Mod 提供的

在 CoT 脚本内

```zenscript
#loader contenttweaker
import mods.contenttweaker.VanillaFactory;
import mods.randomtweaker.cote.SubTileGenerating;
import mods.randomtweaker.cote.SubTileFunctional;

var subTileGenerating as SubTileGenerating = VanillaFactory.createSubTileGenerating("test", 0xFFFFFF);
subTileGenerating.register();

// 即使不是同一类型自定义花, 注册名也不能相同!
// 也不能和植魔或其扩展中已有的自定义花的注册名相同

var subTileFunctional as SubTileFunctional = VanillaFactory.createSubTileFunctional("test_1", 0xFFFFFF);
subTileFunctional.register();
```

在 CrT 脚本内

```zenscript
#loader crafttweaker reloadableevents
<cotSubTile:test>.onUpdate = function(subtile, world, pos) {
    if(!world.remote) {
        if(isNull(subtile.data.time))
            subtile.updateCustomData({time : 0});
        
        if(!isNull(subtile.data.time)) {
            subtile.updateCustomData({time : subtile.data.time.asInt() + 1});
        }
    }
};

<cotSubTile:test_1>.onUpdate = function(subtile, world, pos) {
    if(!world.remote) {
        if(isNull(subtile.data.time))
            subtile.updateCustomData({time : 0});
        
        if(!isNull(subtile.data.time)) {
            subtile.updateCustomData({time : subtile.data.time.asInt() + 1});
        }
    }
};
```