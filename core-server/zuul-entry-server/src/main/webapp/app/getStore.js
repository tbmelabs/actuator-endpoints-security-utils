// @flow
'use strict';

import {applyMiddleware, compose, createStore} from 'redux';
import thunk from 'redux-thunk';

import reducers from './state/reducers';

import createSagaMiddleware from 'redux-saga';
import sagas from './state/sagas';

const sagaMiddleware = createSagaMiddleware();

const store = createStore(
  reducers,
  compose(
    applyMiddleware(thunk, sagaMiddleware),
    window.devToolsExtension ? window.devToolsExtension() : f => f
  )
);

sagas.forEach(saga => sagaMiddleware.run(saga));

export default () => {
  return store;
};
