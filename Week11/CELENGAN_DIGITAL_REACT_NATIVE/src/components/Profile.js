import React from "react";
import { connect } from "react-redux";
import {
  View,
  Text,
  Container,
  Header,
  Content,
  Icon,
  Card,
  CardItem,
  Row,
  Grid,
  Button
} from "native-base";
import FooterSegment from "./Footer";
import { logout } from "../api/actions/user";

class Profile extends React.Component {
  state = {
    FullName: this.props.userInfo.userFullName,

    Address: this.props.userInfo.userAddress,

    Email: this.props.userInfo.userEmail,

    phone: this.props.userInfo.phone
  };
  doLogout = () => {
    this.props.logout();
    this.props.navigation.navigate("Login");
  };
  render() {
    return (
      <Container>
        <Header></Header>
        <Content padder>
          <Card>
            <CardItem header bordered>
              <Grid>
                <Row style={{ flex: 1 }}>
                  <View style={{ flex: 1 }}>
                    {/* <Text>HIII</Text> */}
                    <Text style={{ textAlign: "center" }}>
                      FullName ={this.state.FullName}
                    </Text>
                    <Text style={{ textAlign: "center" }}>
                      Address ={this.state.Address}
                    </Text>
                    <Text style={{ textAlign: "center" }}>
                      Email ={this.state.Email}
                    </Text>
                    <Text style={{ textAlign: "center" }}>
                      Phone ={this.state.phone}
                    </Text>
                  </View>
                </Row>
              </Grid>
            </CardItem>
            <Button danger onPress={this.doLogout}>
              <Text style={{ textAlign: "center" }}> LOGOUT </Text>
            </Button>
          </Card>
        </Content>
        <FooterSegment />
      </Container>
    );
  }
}

const mapDispatchToProps = {
  logout: logout
};

const mapStateToProps = state => {
  return {
    userInfo: state.userInfo
  };
};
export default connect(mapStateToProps, mapDispatchToProps)(Profile);
