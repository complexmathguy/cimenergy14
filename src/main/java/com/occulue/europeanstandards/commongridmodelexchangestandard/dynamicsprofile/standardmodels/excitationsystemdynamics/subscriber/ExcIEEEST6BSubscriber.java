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
 * Subscriber for ExcIEEEST6B related events. .
 *
 * @author your_name_here
 */
@Component("excIEEEST6B-subscriber")
public class ExcIEEEST6BSubscriber extends BaseSubscriber {

  public ExcIEEEST6BSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<ExcIEEEST6B>, ExcIEEEST6B> excIEEEST6BSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllExcIEEEST6BQuery(),
        ResponseTypes.multipleInstancesOf(ExcIEEEST6B.class),
        ResponseTypes.instanceOf(ExcIEEEST6B.class));
  }

  public SubscriptionQueryResult<ExcIEEEST6B, ExcIEEEST6B> excIEEEST6BSubscribe(
      @DestinationVariable UUID excIEEEST6BId) {
    return queryGateway.subscriptionQuery(
        new FindExcIEEEST6BQuery(new LoadExcIEEEST6BFilter(excIEEEST6BId)),
        ResponseTypes.instanceOf(ExcIEEEST6B.class),
        ResponseTypes.instanceOf(ExcIEEEST6B.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
