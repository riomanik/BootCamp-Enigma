import { View, Image } from "react-native";
import React from "react";

import { StyleSheet } from "react-native";

class Splash extends React.Component {
  doRedirect = () => {
    setTimeout(() => {
      this.props.navigation.navigate("Login");
    }, 2500);
  };

  render() {
    return (
      <View style={styles.container}>
        <Image source={require("../../assets/crot.png")} />
        {this.doRedirect()}
      </View>
    );
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: "center",
    alignItems: "center",
    backgroundColor: "#4F6D7A"
  }
});
export default Splash;
