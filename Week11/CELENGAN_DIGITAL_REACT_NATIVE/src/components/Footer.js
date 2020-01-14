import React from "react";
import { Button, Footer, FooterTab, Icon, Text } from "native-base";
import { withNavigation } from "react-navigation";

class FooterSegment extends React.Component {
  render() {
    return (
      <Footer>
        <FooterTab>
          <Button
            onPress={() => {
              this.props.navigation.navigate("Main");
            }}
          >
            <Icon name="home" />
            <Text>Home</Text>
          </Button>
          <Button
            onPress={() => {
              this.props.navigation.navigate("Pay");
            }}
          >
            <Icon name="journal" />
            <Text>Pay</Text>
          </Button>
          <Button
            onPress={() => {
              this.props.navigation.navigate("Profile");
            }}
          >
            <Icon name="person" />
            <Text>Profile</Text>
          </Button>
        </FooterTab>
      </Footer>
    );
  }
}
export default withNavigation(FooterSegment);
