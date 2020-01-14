import React from "react";
import { Provider } from "react-redux";
import { createAppContainer } from "react-navigation";
import { createStackNavigator } from "react-navigation-stack";
import Login from "./src/components/Login";
import HomeScreen from "./src/components/Home";
import { Root } from "native-base";
import Splash from "./src/components/Splash";
import PayScreen from "./src/components/Pay";
import ParkingPayment from "./src/components/ParkingPayment";
import { combineReducers, createStore } from "redux";
import { userActiveReducer, userInfoReducer } from "./src/reducers/user";
import { acountNasabahReducer } from "./src/reducers/nasabah";
import Profile from "./src/components/Profile";

const MainNavigator = createStackNavigator(
  {
    Login: {
      screen: Login,
      navigationOptions: {
        header: null
      }
    },
    Main: {
      screen: HomeScreen,
      navigationOptions: {
        header: null
      }
    },
    Splash: {
      screen: Splash,
      navigationOptions: {
        header: null
      }
    },
    Pay: {
      screen: PayScreen,
      navigationOptions: {
        header: null
      }
    },
    ParkingPayment: {
      screen: ParkingPayment,
      navigationOptions: {
        header: null
      }
    },
    Profile: {
      screen: Profile,
      navigationOptions: {
        header: null
      }
    }
  },

  { initialRouteName: "Splash" }
);

const appReducer = combineReducers({
  userActive: userActiveReducer,
  acountNasabah: acountNasabahReducer,
  userInfo: userInfoReducer
});

const rootReducer = (state, action) => {
  if (action.type === "LOGOUT") {
    state = undefined;
  }
  return appReducer(state, action);
};

const store = createStore(rootReducer);

const AppNavigator = createAppContainer(MainNavigator);

export default () => {
  return (
    <Provider store={store}>
      <Root>
        <AppNavigator />
      </Root>
    </Provider>
  );
};
