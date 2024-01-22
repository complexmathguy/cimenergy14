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
 * Subscriber for ExcBBC related events. .
 *
 * @author your_name_here
 */
@Component("excBBC-subscriber")
public class ExcBBCSubscriber extends BaseSubscriber {

  public ExcBBCSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<ExcBBC>, ExcBBC> excBBCSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllExcBBCQuery(),
        ResponseTypes.multipleInstancesOf(ExcBBC.class),
        ResponseTypes.instanceOf(ExcBBC.class));
  }

  public SubscriptionQueryResult<ExcBBC, ExcBBC> excBBCSubscribe(
      @DestinationVariable UUID excBBCId) {
    return queryGateway.subscriptionQuery(
        new FindExcBBCQuery(new LoadExcBBCFilter(excBBCId)),
        ResponseTypes.instanceOf(ExcBBC.class),
        ResponseTypes.instanceOf(ExcBBC.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
