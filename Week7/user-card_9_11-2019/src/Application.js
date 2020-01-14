import React from "react";
import ReactDOM from "react-dom";
import Login from "./component/Login";
import Product from "./component/Product";
import Content from "./component/Content";
import "./index.css";
import "./index2.css";
import About from "./component/About";
class App extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      Login: false,
      Product: false,
      About: false,
      contentAbout: null
    };
  }
  UserSession = action => {
    this.setState({ Login: action });
  };
  UserProduct = action => {
    this.setState({ Product: action });
  };
  UserAbout = action => {
    this.setState({ About: action });
  };
  render() {
    if (this.state.Product === true) {
      return <Product Logout={this.UserProduct} />;
    }
    // if (this.state.About === true) {
    //   return (
    //     <div>
    //       <Content
    //         ChangeLogout={this.UserSession}
    //         ChangeProduct={this.UserProduct}
    //         doShowAbout={this.UserAbout}
    //       />
    //       ,<About doAbout={this.UserAbout} />;
    //     </div>
    //   );
    // }

    if (this.state.Login === true) {
      if (this.state.About === false) {
        return (
          <div>
            <Content
              ChangeLogout={this.UserSession}
              ChangeProduct={this.UserProduct}
              doShowAbout={this.UserAbout}
            />
          </div>
        );
      }
      if (this.state.About === true) {
        return (
          <div>
            <Content
              ChangeLogout={this.UserSession}
              ChangeProduct={this.UserProduct}
              doShowAbout={this.UserAbout}
              // Content="Vivamus maximus bibendum iaculis. Vivamus laoreet pellentesque eros, ut venenatis ex lacinia ut. Nulla eget molestie dui. Nunc suscipit mattis commodo. In nec aliquam massa. Nunc rutrum vel augue pulvinar mattis. Etiam quis massa accumsan ipsum malesuada fringilla et eget felis. Fusce commodo erat eget sapien vulputate pulvinar. Donec eleifend purus id ligula egestas feugiat. Aliquam iaculis massa sit amet dui pulvinar, ac efficitur mauris posuere. Aenean aliquam lacus elit, a venenatis tellus egestas quis. Donec non sagittis diam. Phasellus ac rhoncus velit. Curabitur viverra tellus id nulla viverra, non eleifend metus luctus.Pellentesque ac mi eu ipsum iaculis varius. Donec quis euismod lectus. Quisque semper, nulla in interdum elementum, nulla neque mattis felis, vel scelerisque metus eros eu erat. Sed posuere in justo eu venenatis. Sed magna ligula, elementum eu turpis eleifend, viverra accumsan felis. Sed dolor sapien, volutpat vel orci sit amet, aliquam ornare dolor. Donec sit amet metus at nibh fringilla bibendum. Morbi at massa arcu. Duis ac nunc turpis. Proin scelerisque varius hendrerit. Morbi malesuada at eros nec fringilla. In hac habitasse platea dictumst. Pellentesque iaculis volutpat vulputate. Donec suscipit et mi et imperdiet. Praesent a semper ipsum.Vivamus ac nunc sagittis, gravida elit sit amet, lobortis leo. Aenean in velit id sem facilisis bibendum at eget arcu. Quisque ac leo tempus, consequat lorem in, pulvinar lectus. Curabitur lacinia felis non metus suscipit, sit amet commodo massa vulputate. Etiam vitae venenatis mi. Etiam laoreet massa eu egestas fermentum. Morbi purus nulla, euismod a auctor at, congue at neque. Nulla feugiat cursus ex eget tincidunt. Cras lacus enim, eleifend nec mollis id, facilisis a risus. Suspendisse ac malesuada orci, nec venenatis magna. Aenean lacus sem, malesuada a sodales at, eleifend nec tellus. Duis molestie ullamcorper posuere. Fusce sed velit a est vestibulum egestas egestas sed odio. Ut aliquet bibendum semper. Pellentesque euismod nisi dolor, nec viverra odio tempus non.Curabitur varius ultrices turpis, at porta turpis eleifend nec. Nulla nec dignissim erat. Nullam mattis est in ultricies venenatis. Aliquam feugiat mollis viverra. Aenean maximus lobortis efficitur. Ut pulvinar risus leo, ac mattis eros imperdiet a. Curabitur varius quam eu arcu laoreet varius. Sed vitae ex quis nisi volutpat ullamcorper. In vulputate turpis id risus posuere varius. Mauris vel elit nibh. Curabitur laoreet, urna at interdum commodo, ligula tortor feugiat arcu, ut tempor tortor tortor sit amet diam. Fusce in laoreet lorem.Aenean risus lorem, congue nec rhoncus et, auctor in arcu. Fusce pretium, turpis sit amet molestie aliquet, elit orci convallis lectus, in accumsan neque tellus nec lectus. Nunc eros nisl, dignissim quis diam eget, commodo eleifend lectus. Duis a nibh ipsum. Duis ac pharetra sapien. Maecenas eget pellentesque sapien. Morbi porttitor, turpis ac egestas interdum, tellus augue viverra eros, a maximus nibh tortor in ipsum. Aenean scelerisque ut erat a semper. Ut vitae nibh diam. Suspendisse dictum nisl in lacus varius lacinia. Phasellus facilisis vestibulum eleifend. Sed non egestas risus. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Interdum et malesuada fames ac ante ipsum primis in faucibus. Phasellus molestie placerat tincidunt. Curabitur aliquet tellus vitae commodo sagittis.Vestibulum tellus felis, scelerisque eget nisi ac, varius maximus urna. Aliquam lacinia luctus neque ac finibus. Fusce volutpat libero vel vulputate viverra. Aliquam accumsan in magna vitae pellentesque. Sed enim libero, scelerisque sed eleifend eu, blandit rhoncus sem. Vestibulum in justo ultricies, cursus mi vel, posuere mauris. Sed dignissim quam ante, nec sagittis lacus vestibulum id. Vestibulum convallis facilisis risus ut pretium. Nunc non tortor consequat, sagittis leo quis, pharetra purus. Nulla suscipit elementum elementum. Aenean dui nulla, blandit in erat eu, varius accumsan arcu. Maecenas nibh lectus, pellentesque eget turpis ut, dictum sodales erat. Morbi et ipsum condimentum urna tincidunt ullamcorper. Quisque aliquam consectetur lobortis Donec quam elit, tristique vitae aliquam lobortis, tincidunt non metus. Vestibulum eget lobortis nisi. Maecenas aliquam egestas quam quis interdum. Donec id metus viverra velit tristique laoreet ac eu ex. Nulla sagittis elit dui, quis aliquet augue tempor sed. Donec pellentesque rutrum dapibus. Proin venenatis est sed magna maximus aliquet. Nullam eu elit ut dolor commodo mollis sed convallis nunc. Etiam ut arcu lobortis diam elementum consequat. Cras vel neque sit amet est ullamcorper vulputate. Phasellus at eros sed nibh accumsan suscipit. Suspendisse a felis imperdiet, tincidunt massa quis, semper nibh. Nunc vitae aliquam ex. Aenean nec est varius, dignissim tortor sit amet, finibus leo. Pellentesque consequat varius magna, ac dictum felis posuere quis. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas"
            />
            ,<About doShowAbout={this.UserAbout} doAbout={this.UserAbout} />
          </div>
        );
      }
    } else {
      return <Login ChangeSession={this.UserSession} />;
    }
  }
}
export default App;

// PEMANGGILAN
