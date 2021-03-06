# 工厂模式
## 1.简单工厂模式
```
优点: 简单, 无须复杂的封装
缺点: 1.可能返回null 2.type可能硬编码或增加多余枚举 3.需要创建factory实体(可以通过将produce改为静态方法优化)
```

## 2.多方法工厂模式
```
优点: 相比较简单工厂模式更优雅, 降低硬编码或null的可能性, 利于调用
缺点: 需要创建factory实体(可以通过将produce改为静态方法优化)
```

## 3.静态工厂模式
```
优点: 在简单工厂模式/多方法工厂模式基础上将工厂方法静态化, 便于调用
缺点: 工厂方法的通用缺陷, 即拓展必须修改工厂类(实际上我觉得一般情况下可以接受)
```

## 4.抽象工厂模式
```
优点: 在工厂模式的基础上将工厂类也抽象出接口, 可以在无修改原先代码的基础上拓展程序, 符合开闭原则
缺点: 过于复杂, 在简单应用中强套抽象工厂模式有滥用设计模式的嫌疑
```