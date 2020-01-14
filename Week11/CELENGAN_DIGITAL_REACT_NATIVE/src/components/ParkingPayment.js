import React from "react";
import * as Permissions from "expo-permissions";
import { Button, Container, Content, Header, Text, View } from "native-base";
import { BarCodeScanner } from "expo-barcode-scanner";
import { StyleSheet, Vibration } from "react-native";
import FooterSegment from "./Footer";

class ParkingPayment extends React.Component {
  state = {
    hasCameraPermission: null,
    scanned: false
  };

  componentDidMount() {
    this.getPermission();
  }

  getPermission = async () => {
    const { status } = await Permissions.askAsync(Permissions.CAMERA);
    this.setState({ hasCameraPermission: status === "granted" });
  };
  handleBarCodeScanned = ({ type, data }) => {
    Vibration.vibrate();
    this.setState({ scanned: true });
    alert(`Bar code with type ${type} and data ${data} has been scanned!`);
  };

  resetScanner() {
    this.setState({
      scanned: false
    });
  }

  render() {
    return (
      <Container>
        <Header></Header>
        <Content>
          <BarCodeScanner
            onBarCodeScanned={
              this.state.scanned ? undefined : this.handleBarCodeScanned
            }
            style={styles.cameraView}
          />
          <View style={{ marginTop: 10 }}>
            <Button
              style={styles.buttonScan}
              full
              rounded
              onPress={() => this.setState({ scanned: false })}
            >
              <Text>Scan Again</Text>
            </Button>
          </View>
        </Content>
        <FooterSegment />
      </Container>
    );
  }
}

const styles = StyleSheet.create({
  buttonScan: {
    width: 200,
    marginLeft: "auto",
    marginRight: "auto"
  },
  cameraView: {
    height: 600,
    width: "100%"
  }
});

export default ParkingPayment;
