# About 

# Architecture - MVVM architecure
I find it very efficient and specially being able to seperate components, we have a capability of builting better solutions with better code maintainance

# Why 
ViewModels are simples classes/objects that interacts with the logic/model layer and just exposes states/data and actually has no idea by whom or how that data will be consumed. Only View(Activity) holds the reference to ViewModel and not vice versa, this solves our biggest problem in android development which is tight coupling issue. A single view can hold reference to multiple ViewModels.

# Frameworks/Platforms :
I've used following frameworks in order to improve it in certain areas such as netwoking, code injction, data persistance.

- Dagger2 
- Room
- Retrofit
- RxJava

# Configurations
configure following parameters based on your requirement
  - SCHEDULE_PERIOD_DAYS: Int = 10
  - MAX_SHIFTS_PER_DAY: Int = 2
  - MAX_SHIFTS_PER_USER: Int = 2
  - USER_OFF_DAYS: Int = 1


# Api
I have created a simple api using apiary :
- http://private-4269b25-engineers1.apiary-mock.com/
