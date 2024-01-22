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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.excitationsystemdynamics.subscriber;

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
 * Subscriber for ExcCZ related events. .
 *
 * @author your_name_here
 */
@Component("excCZ-subscriber")
public class ExcCZSubscriber extends BaseSubscriber {

  public ExcCZSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<ExcCZ>, ExcCZ> excCZSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllExcCZQuery(),
        ResponseTypes.multipleInstancesOf(ExcCZ.class),
        ResponseTypes.instanceOf(ExcCZ.class));
  }

  public SubscriptionQueryResult<ExcCZ, ExcCZ> excCZSubscribe(@DestinationVariable UUID excCZId) {
    return queryGateway.subscriptionQuery(
        new FindExcCZQuery(new LoadExcCZFilter(excCZId)),
        ResponseTypes.instanceOf(ExcCZ.class),
        ResponseTypes.instanceOf(ExcCZ.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
