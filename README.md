# Android Architecture Blueprints

<img src="https://github.com/googlesamples/android-architecture/wiki/images/aab-logo.png" alt="Android Architecture Blueprints"/>

Android框架为决定如何组织和构建Android应用程序提供了很大的灵活性。虽然这种自由是非常有价值的，但它也可能导致应用程序具有大类，不一致的命名方案，以及不匹配或缺少架构。这些类型的问题可能使测试，维护和扩展您的应用程序困难。

Android Architecture Blueprints项目演示了帮助解决或避免这些常见问题的策略。该项目使用不同的架构概念和工具来实现相同的应用程序。

您可以将此项目中的示例用作学习参考，或者作为创建自己的应用程序的起点。此项目的重点是演示如何构建代码，设计架构以及采用这些模式对测试和维护应用程序的最终影响。您可以用许多不同的方式使用这里展示的技术来构建应用程序。你自己的优先考虑将影响你在这些项目中实现这些概念的方式，所以你不应该把这些样本看作是典型的例子。为确保重点保持上述目标，应用程序使用简单的用户界面。

## 搜索样品

该项目将每个示例应用程序托管在单独的存储库分支中 有关更多信息，请参阅每个分支中的`README.md`文件。

### Stable samples - Java
| 样品 | 描述 |
| ------------- | ------------- |
| [todo‑mvp](https://github.com/googlesamples/android-architecture/tree/todo-mvp/) | 演示了一个基本的 [Model‑View‑Presenter](https://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93presenter) (MVP) 体系结构并为其他示例提供了基础。这个样本也可以作为比较和对照本项目其他样本的参考点。 |
| [todo‑mvp‑clean](https://github.com/googlesamples/android-architecture/tree/todo-mvp-clean/) | 使用 [Clean Architecture](https://8thlight.com/blog/uncle-bob/2012/08/13/the-clean-architecture.html)的概念。|
| [todo‑mvp‑dagger](https://github.com/googlesamples/android-architecture/tree/todo-mvp-dagger/) | 使用 [Dagger 2](https://google.github.io/dagger/) 添加对 [dependency injection](https://en.wikipedia.org/wiki/Dependency_injection)的支持。|
| [todo‑mvp‑rxjava](https://github.com/googlesamples/android-architecture/tree/todo-mvp-rxjava/) | 使用 [RxJava 2](https://github.com/ReactiveX/RxJava) 来实现并发性，并抽象数据层。|
| [todo‑mvvm‑databinding](https://github.com/googlesamples/android-architecture/tree/todo-mvvm-databinding/) | 基于 todo-databinding 示例, 此版本包含 [Model‑View‑ViewModel](https://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93viewmodel) 模式。|
| [todo‑mvvm‑live](https://github.com/googlesamples/android-architecture/tree/todo-mvvm-live/) | 使用 [Architecture Components](http://developer.android.com/arch) 中的ViewModels和LiveData以及MVVM体系结构的Data Binding库。|

### Stable samples - Kotlin
| Sample | Description |
| ------------- | ------------- |
| [todo-mvp-kotlin](https://github.com/googlesamples/android-architecture/tree/todo-mvp-kotlin/) | Conversion of todo-mvp to Kotlin. |
| [todo-mvvm-live-kotlin](https://github.com/googlesamples/android-architecture/tree/todo-mvvm-live-kotlin/) | Conversion of todo-mvvm-live to Kotlin. |


## Why a to-do app?

这个项目中的应用程序旨在简单到可以快速理解，但是足够复杂以展示难以设计的决策和测试场景。 有关更多信息，请参阅 [app's specification](https://github.com/googlesamples/android-architecture/wiki/To-do-app-specification).

## 为您的应用选择一个示例

每个示例都包含一个专用的`README.md`文件，您可以在其中找到相关度量标准，以及贡献者的主观评估和观察结果。 为您的应用选择特定样本时，需要考虑以下因素：

* 您正在开发的应用程序的大小
* 你的团队的规模和经验
* 您所期望的维护量
* 无论您需要平板电脑布局
* 无论您需要支持多个平台
* 您对代码库的紧凑性的偏好

有关选择和比较样本的更多信息，请参阅以下页面：
* [样品一目了然](https://github.com/googlesamples/android-architecture/wiki/Samples-at-a-glance)
* [如何比较样本](https://github.com/googlesamples/android-architecture/wiki/How-to-compare-samples)

## 在Android Studio中打开示例

要在Android Studio中打开其中一个样本，首先检查一个样本分支，然后在Android Studio中打开`app /`目录。 以下一系列步骤说明如何打开 [todo‑mvp](https://github.com/googlesamples/android-architecture/tree/todo-mvp) 样品.

**Note:** 主分支不编译。

克隆存储库：
```
git clone git@github.com:txwgoogol/android-architecture-weather.git
```
检出todo-mvp示例：
```
git checkout todo-mvp
```
**Note:** 要查看不同的样品，请用您想要检出的样品名称替换“todo-mvp”。

最后在Android Studio中打开`todoapp /`目录。

仿照googlesamples android-architecture 开发一个天气应用
