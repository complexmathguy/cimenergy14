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
 * Subscriber for ExcHU related events. .
 *
 * @author your_name_here
 */
@Component("excHU-subscriber")
public class ExcHUSubscriber extends BaseSubscriber {

  public ExcHUSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<ExcHU>, ExcHU> excHUSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllExcHUQuery(),
        ResponseTypes.multipleInstancesOf(ExcHU.class),
        ResponseTypes.instanceOf(ExcHU.class));
  }

  public SubscriptionQueryResult<ExcHU, ExcHU> excHUSubscribe(@DestinationVariable UUID excHUId) {
    return queryGateway.subscriptionQuery(
        new FindExcHUQuery(new LoadExcHUFilter(excHUId)),
        ResponseTypes.instanceOf(ExcHU.class),
        ResponseTypes.instanceOf(ExcHU.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
