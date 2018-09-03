import React, {Component} from 'react';
import {Platform, StyleSheet, Text, View, TextInput, Button} from 'react-native';


type Props = {};
export default class App extends Component<Props> {
  constructor(props) {
    super(props);
    this.state = { text: '', visible: false, borderColor: 'gray' };

    this.onPressHello = this.onPressHello.bind(this);
    this.onPressClear = this.onPressClear.bind(this);
    this.onFocus = this.onFocus.bind(this);
    this.onBlur = this.onBlur.bind(this);
  }

  onPressHello() {
    this.setState({ visible: true });
  }

  onPressClear() {
    this.setState({visible: false, text: ''});
  }

  onBlur() {
    this.setState({borderColor: 'gray'});
  }

  onFocus() {
    this.setState({borderColor: 'red'});
  }

  render() {
    return (
      <View style={styles.container}>
        <TextInput
          style={{height: 40, width: '90%', borderColor: this.state.borderColor, borderWidth: 1}}
          onChangeText={(text) => this.setState({text})}
          value={this.state.text}
          placeholder="Input your name"
          clearButtonMode='always'
          onFocus={this.onFocus}
          onBlur={this.onBlur}
        />
        <Button title="Clear text" color="#841584" onPress={this.onPressClear}/>
        <Button title="Say hello" color="#841584" onPress={this.onPressHello}/>
        { (this.state.text !== '' && this.state.visible === true) ? <Text>{'Hello ' + this.state.text + '!'}</Text> : null }
      </View>
    );
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#F5FCFF',
  }
});
