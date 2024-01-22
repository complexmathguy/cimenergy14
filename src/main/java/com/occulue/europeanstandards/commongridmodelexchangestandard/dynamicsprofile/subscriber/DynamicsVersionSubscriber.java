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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.subscriber;

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
 * Subscriber for DynamicsVersion related events. .
 *
 * @author your_name_here
 */
@Component("dynamicsVersion-subscriber")
public class DynamicsVersionSubscriber extends BaseSubscriber {

  public DynamicsVersionSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<DynamicsVersion>, DynamicsVersion>
      dynamicsVersionSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllDynamicsVersionQuery(),
        ResponseTypes.multipleInstancesOf(DynamicsVersion.class),
        ResponseTypes.instanceOf(DynamicsVersion.class));
  }

  public SubscriptionQueryResult<DynamicsVersion, DynamicsVersion> dynamicsVersionSubscribe(
      @DestinationVariable UUID dynamicsVersionId) {
    return queryGateway.subscriptionQuery(
        new FindDynamicsVersionQuery(new LoadDynamicsVersionFilter(dynamicsVersionId)),
        ResponseTypes.instanceOf(DynamicsVersion.class),
        ResponseTypes.instanceOf(DynamicsVersion.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
