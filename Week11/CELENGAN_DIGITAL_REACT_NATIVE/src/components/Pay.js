import React from "react";
import {
  Button,
  Container,
  Content,
  Header,
  Icon,
  Text,
  View
} from "native-base";
import { StyleSheet } from "react-native";
import FooterSegment from "./Footer";

class PayScreen extends React.Component {
  doParkingPay = () => {
    this.props.navigation.navigate("ParkingPayment");
  };

  render() {
    return (
      <Container>
        <Header></Header>
        <Content>
          <Text style={styles.pageHeader}>Pay / TopUp</Text>
          <View style={{ flexDirection: "row", flexWrap: "wrap", flex: 1 }}>
            <Button transparent style={styles.buttonService}>
              <Icon name="baterry-charging">
                <Text>Listrik</Text>
              </Icon>
            </Button>
            <Button transparent style={styles.buttonService}>
              <Icon name="card">
                <Text>TopUp</Text>
              </Icon>
            </Button>
            <Button
              transparent
              style={styles.buttonService}
              onPress={this.doParkingPay}
            >
              <Icon name="subway">
                <Text>Parkir</Text>
              </Icon>
            </Button>
          </View>
        </Content>
        <FooterSegment />
      </Container>
    );
  }
}

const styles = StyleSheet.create({
  pageHeader: {
    color: "#0cb9ff",
    fontWeight: "bold",
    margin: 15
  },
  buttonService: {
    flexDirection: "column",
    margin: 10
  }
});

export default PayScreen;
