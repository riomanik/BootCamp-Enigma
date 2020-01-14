import React from "react";
import { connect } from "react-redux";
import {
  View,
  Grid,
  Text,
  Thumbnail,
  Label,
  Button,
  Row,
  Form,
  Item,
  Input,
  Spinner
} from "native-base";
import { StyleSheet } from "react-native";
import * as Font from "expo-font";
import { doAuth } from "../api/user";
import { BackHandler, Alert } from "react-native";
import { authUser, acountNasabah, userInfo } from "../api/actions/user";

class Login extends React.Component {
  state = { userPin: "", loading: true, username: "", password: "" };

  doLoading = () => {
    this.setState({ loading: false });
  };

  async componentWillMount() {
    await Font.loadAsync({
      Roboto: require("../../node_modules/native-base/Fonts/Roboto.ttf"),
      Roboto_medium: require("../../node_modules/native-base/Fonts/Roboto_medium.ttf")
    });
    this.setState({ loading: false });
    this.backHandler = BackHandler.addEventListener("hardwareBackPress", () => {
      return true;
    });
  }

  doLogin = async () => {
    this.setState({ loading: false });
    let data;
    await doAuth(this.state.username, this.state.password)
      .then(response => {
        console.log(response);
        data = response;
        console.log(JSON.stringify(data.status) + "ini data status");
        if (data.status === 200) {
          Alert.alert("succes", "Login Berhasil");
          console.log(data.data[0].userFullName + "ini username");
          let userFullName = data.data[0].userFullName;
          let nasabah = data;
          this.props.authUser(userFullName);
          this.props.acountNasabah(nasabah.data);
          this.props.userInfo(nasabah.data[0]);
          this.props.navigation.navigate("Main");
        }
      })
      .catch(err => {
        Alert.alert("failed");
        this.setState({ username: "", password: "", loading: false });
      });
    console.log(data.status);
  };
  render() {
    const uri =
      "http://facebook.github.io/react-native/docs/assets/favicon.png";
    if (this.state.loading) {
      return (
        <View style={{ flex: 1, justifyContent: "center" }}>
          <Text>LOADING</Text>
          <Spinner />
        </View>
      );
    } else {
      return (
        <View style={styles.background}>
          <Grid>
            <Row
              size={1}
              style={{
                paddingTop: 50,
                width: "100%",
                justifyContent: "center",
                alignItems: "center"
              }}
            >
              <Thumbnail small source={{ uri: uri }}></Thumbnail>
            </Row>
            <Row
              size={1}
              style={{ flexDirection: "column", padding: 30, width: "100%" }}
            >
              <Form>
                <Item stackedLabel>
                  <Label style={styles.loginText}>Username</Label>
                  <Input
                    // placeholder="Input UserName"
                    onChangeText={value => this.setState({ username: value })}
                    value={this.state.username}
                  />
                </Item>
                <Item stackedLabel>
                  <Label style={styles.loginText}>Password</Label>
                  <Input
                    // placeholder="Input Password"
                    onChangeText={value => this.setState({ password: value })}
                    value={this.state.password}
                  />
                </Item>
              </Form>
            </Row>
            <Row
              size={2}
              style={{
                flexDirection: "column",
                padding: 60,
                width: "100%"
              }}
            >
              <Button
                block
                style={styles.buttonLogin}
                full
                rounded
                onPress={this.doLogin}
              >
                <Text style={styles.buttonLoginText}>Login</Text>
              </Button>
            </Row>
          </Grid>
        </View>
      );
    }
  }
}
const styles = StyleSheet.create({
  background: {
    flex: 1,
    backgroundColor: "#0cb911"
  },
  loginText: {
    color: "#F5F5F5"
  },
  loginTextHeader: {
    color: "#F5F5F5",
    fontSize: 24,
    fontWeight: "bold"
  },
  buttonLoginText: {
    color: "#F5F5F5"
  }
});

const mapDispatchToProps = {
  authUser: authUser,
  acountNasabah: acountNasabah,
  userInfo: userInfo
};
export default connect(null, mapDispatchToProps)(Login);
