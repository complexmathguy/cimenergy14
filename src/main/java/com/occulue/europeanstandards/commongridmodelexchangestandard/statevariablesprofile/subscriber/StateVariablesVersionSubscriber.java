/**
 * ***************************************************************************** Turnstone Biologics
 * Confidential
 *
 * <p>2018 Turnstone Biologics All Rights Reserved.
 *
 * <p>This file is subject to the terms and conditions defined in file 'license.txt', which is part
 * of this source code package.
 *
 * <p>Contributors : Turnstone Biologics - General Release
 * ****************************************************************************
 */
package com.occulue.europeanstandards.commongridmodelexchangestandard.statevariablesprofile.subscriber;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.exception.*;
import com.occulue.subscriber.*;
import java.util.*;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.queryhandling.SubscriptionQueryResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.stereotype.Component;

/**
 * Subscriber for StateVariablesVersion related events. .
 *
 * @author your_name_here
 */
@Component("stateVariablesVersion-subscriber")
public class StateVariablesVersionSubscriber extends BaseSubscriber {

  public StateVariablesVersionSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<StateVariablesVersion>, StateVariablesVersion>
      stateVariablesVersionSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllStateVariablesVersionQuery(),
        ResponseTypes.multipleInstancesOf(StateVariablesVersion.class),
        ResponseTypes.instanceOf(StateVariablesVersion.class));
  }

  public SubscriptionQueryResult<StateVariablesVersion, StateVariablesVersion>
      stateVariablesVersionSubscribe(@DestinationVariable UUID stateVariablesVersionId) {
    return queryGateway.subscriptionQuery(
        new FindStateVariablesVersionQuery(
            new LoadStateVariablesVersionFilter(stateVariablesVersionId)),
        ResponseTypes.instanceOf(StateVariablesVersion.class),
        ResponseTypes.instanceOf(StateVariablesVersion.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
