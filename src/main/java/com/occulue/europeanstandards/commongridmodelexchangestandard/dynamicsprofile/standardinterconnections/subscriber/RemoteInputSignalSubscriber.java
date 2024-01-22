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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardinterconnections.subscriber;

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
 * Subscriber for RemoteInputSignal related events. .
 *
 * @author your_name_here
 */
@Component("remoteInputSignal-subscriber")
public class RemoteInputSignalSubscriber extends BaseSubscriber {

  public RemoteInputSignalSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<RemoteInputSignal>, RemoteInputSignal>
      remoteInputSignalSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllRemoteInputSignalQuery(),
        ResponseTypes.multipleInstancesOf(RemoteInputSignal.class),
        ResponseTypes.instanceOf(RemoteInputSignal.class));
  }

  public SubscriptionQueryResult<RemoteInputSignal, RemoteInputSignal> remoteInputSignalSubscribe(
      @DestinationVariable UUID remoteInputSignalId) {
    return queryGateway.subscriptionQuery(
        new FindRemoteInputSignalQuery(new LoadRemoteInputSignalFilter(remoteInputSignalId)),
        ResponseTypes.instanceOf(RemoteInputSignal.class),
        ResponseTypes.instanceOf(RemoteInputSignal.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
