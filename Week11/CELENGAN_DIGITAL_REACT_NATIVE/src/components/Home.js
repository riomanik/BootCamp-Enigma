import React from "react";
import { connect } from "react-redux";
import {
  View,
  Text,
  Container,
  Header,
  Content,
  Button,
  Icon,
  Card,
  CardItem,
  Row,
  ListItem,
  Grid
} from "native-base";
import { StyleSheet } from "react-native";
import FooterSegment from "./Footer";

class Home extends React.Component {
  state = {
    isShowDetail: false,
    iconName: "arrow-dropdown",
    userActive: this.props.userActive,
    Saving: this.props.acountNasabahReducer[0].nasabah.saving,
    Loan: this.props.acountNasabahReducer[0].nasabah.loan,
    Deposito: this.props.acountNasabahReducer[0].nasabah.deposito
  };
  acountNasab;
  doShowDetail = () => {
    if (this.state.isShowDetail) {
      return (
        <Row style={{ height: 125 }}>
          <View>
            <ListItem>
              <Text>Saldo : {this.state.Saving}</Text>
            </ListItem>
            <ListItem>
              <Text>Loan : {this.state.Loan}</Text>
            </ListItem>
            <ListItem>
              <Text>Deposito : {this.state.Deposito}</Text>
            </ListItem>
          </View>
        </Row>
      );
    } else {
      return null;
    }
  };

  render() {
    return (
      <Container>
        <Header>
          <Button iconLeft>
            <Icon name="home" />
            <Text>Home</Text>
          </Button>
          <Button iconRight primary>
            <Icon name="cog" />
            <Text>Settings</Text>
          </Button>
        </Header>
        <Content padder>
          <Card>
            <CardItem header bordered>
              <Grid>
                <Row style={{ flex: 1 }}>
                  <View style={{ flex: 1 }}>
                    <Text style={{ textAlign: "center" }}>
                      HALLO ,.. {this.state.userActive}
                    </Text>
                  </View>
                </Row>
                {this.doShowDetail()}
              </Grid>
            </CardItem>
            <CardItem
              footer
              button
              onPress={() => {
                if (this.state.isShowDetail) {
                  this.setState({
                    isShowDetail: !this.state.isShowDetail,
                    iconName: "arrow-dropdown"
                  });
                } else {
                  this.setState({
                    isShowDetail: !this.state.isShowDetail,
                    iconName: "arrow-dropup"
                  });
                }
              }}
            >
              <View style={{ flex: 1 }}>
                <Text style={{ textAlign: "center" }}>
                  <Icon name={this.state.iconName}></Icon>
                </Text>
              </View>
            </CardItem>
          </Card>
        </Content>
        <FooterSegment />
      </Container>
    );
  }
}
const styles = StyleSheet.create({
  background: {
    flex: 1,
    backgroundColor: "#0cb9ff"
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
    backgroundColor: "#F5F5F5"
  }
});
const mapStateToProps = state => {
  return {
    userActive: state.userActive,
    acountNasabahReducer: state.acountNasabah
  };
};
export default connect(mapStateToProps)(Home);
