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
 * Subscriber for AngleDegrees related events. .
 *
 * @author your_name_here
 */
@Component("angleDegrees-subscriber")
public class AngleDegreesSubscriber extends BaseSubscriber {

  public AngleDegreesSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<AngleDegrees>, AngleDegrees> angleDegreesSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllAngleDegreesQuery(),
        ResponseTypes.multipleInstancesOf(AngleDegrees.class),
        ResponseTypes.instanceOf(AngleDegrees.class));
  }

  public SubscriptionQueryResult<AngleDegrees, AngleDegrees> angleDegreesSubscribe(
      @DestinationVariable UUID angleDegreesId) {
    return queryGateway.subscriptionQuery(
        new FindAngleDegreesQuery(new LoadAngleDegreesFilter(angleDegreesId)),
        ResponseTypes.instanceOf(AngleDegrees.class),
        ResponseTypes.instanceOf(AngleDegrees.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
