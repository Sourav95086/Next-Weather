🌦️ NextWeather — Android Weather App

📖 Overview
NextWeather is a simple, modern Android weather application that fetches and displays real-time weather data for any city in the world using the OpenWeather API. It provides users with a clean, easy-to-read interface displaying current weather conditions with corresponding icons and visualizations.

📱 Features
🌐 Live Weather Data for any city worldwide

🌡️ Current Temperature

🌡️ Feels Like Temperature

📖 Weather Description

🔺 Max Temperature

🔻 Min Temperature

💧 Humidity Percentage

🌬️ Air Speed

🔍 Search Bar to quickly check the weather for any city

🖼️ Image Visualisation based on current weather (sunny, cloudy, rainy, etc.)

📸 Screenshots
Splash Screen : 
Default Screen :	
Live Weather Screen :

⚙️ Tech Stack
Android (Java)

Retrofit — for API calls

Gson Converter — for JSON parsing

OpenWeatherMap API — for live weather data

Material Design Components

🌐 API Integration
Using OpenWeatherMap API with base URL:

ruby
Copy
Edit
https://api.openweathermap.org/data/2.5/
Example endpoint:

bash
Copy
Edit
https://api.openweathermap.org/data/2.5/weather?q={city name}&appid={your api key}&units=metric
📦 Installation
Clone the repository:

bash
Copy
Edit
git clone https://github.com/yourusername/NextWeather.git
Open in Android Studio

Replace YOUR_API_KEY with your OpenWeather API key in ApiInterface.java or MainActivity.java

Run the app on an Android emulator or real device

📜 License
This project is open-source and available under the MIT License.

👤 Author
Sourav Chakrabortty
GitHub | LinkedIn

⭐️ Show Your Support
If you like this project, consider giving it a ⭐️ on GitHub!
