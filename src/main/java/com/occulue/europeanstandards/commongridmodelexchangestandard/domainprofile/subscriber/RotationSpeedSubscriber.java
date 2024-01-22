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
package com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.subscriber;

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
 * Subscriber for RotationSpeed related events. .
 *
 * @author your_name_here
 */
@Component("rotationSpeed-subscriber")
public class RotationSpeedSubscriber extends BaseSubscriber {

  public RotationSpeedSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<RotationSpeed>, RotationSpeed> rotationSpeedSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllRotationSpeedQuery(),
        ResponseTypes.multipleInstancesOf(RotationSpeed.class),
        ResponseTypes.instanceOf(RotationSpeed.class));
  }

  public SubscriptionQueryResult<RotationSpeed, RotationSpeed> rotationSpeedSubscribe(
      @DestinationVariable UUID rotationSpeedId) {
    return queryGateway.subscriptionQuery(
        new FindRotationSpeedQuery(new LoadRotationSpeedFilter(rotationSpeedId)),
        ResponseTypes.instanceOf(RotationSpeed.class),
        ResponseTypes.instanceOf(RotationSpeed.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
