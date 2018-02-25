'use strict';

import React, {Component} from 'react';
import PropTypes from 'prop-types';

import Jumbotron from 'react-bootstrap/lib/Jumbotron';

require('../../styles/signup.css');

class SignupJumbotron extends Component {
  render() {
    const {texts} = this.props;

    return (
      <Jumbotron>
        <h1>{texts.jumbotron_title}</h1>
        <p>{texts.jumbotron_text}</p>
      </Jumbotron>
    );
  }
}

SignupJumbotron.propTypes = {
  texts: PropTypes.object.isRequired
}

export default SignupJumbotron;