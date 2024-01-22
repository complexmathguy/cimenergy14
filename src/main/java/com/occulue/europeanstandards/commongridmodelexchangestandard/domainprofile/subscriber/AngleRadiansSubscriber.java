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
 * Subscriber for AngleRadians related events. .
 *
 * @author your_name_here
 */
@Component("angleRadians-subscriber")
public class AngleRadiansSubscriber extends BaseSubscriber {

  public AngleRadiansSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<AngleRadians>, AngleRadians> angleRadiansSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllAngleRadiansQuery(),
        ResponseTypes.multipleInstancesOf(AngleRadians.class),
        ResponseTypes.instanceOf(AngleRadians.class));
  }

  public SubscriptionQueryResult<AngleRadians, AngleRadians> angleRadiansSubscribe(
      @DestinationVariable UUID angleRadiansId) {
    return queryGateway.subscriptionQuery(
        new FindAngleRadiansQuery(new LoadAngleRadiansFilter(angleRadiansId)),
        ResponseTypes.instanceOf(AngleRadians.class),
        ResponseTypes.instanceOf(AngleRadians.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
