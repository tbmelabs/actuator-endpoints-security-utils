// @flow

import {Action} from 'redux';

import {
  REQUEST_CLIENT_GRANT_TYPES,
  SET_CLIENT_GRANT_TYPES
} from './grantType.types';

import {type GrantTypeState} from '../../reducers/grantType.reducer';

export function setClientGrantTypesAction(page: GrantTypeState): Action {
  return {
    type: SET_CLIENT_GRANT_TYPES,
    payload: page
  };
}

export function requestClientGrantTypesAction(): Action {
  return {
    type: REQUEST_CLIENT_GRANT_TYPES
  };
}