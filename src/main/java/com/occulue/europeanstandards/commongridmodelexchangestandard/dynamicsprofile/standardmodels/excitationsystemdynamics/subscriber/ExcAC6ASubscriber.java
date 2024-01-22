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
 * Subscriber for ExcAC6A related events. .
 *
 * @author your_name_here
 */
@Component("excAC6A-subscriber")
public class ExcAC6ASubscriber extends BaseSubscriber {

  public ExcAC6ASubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<ExcAC6A>, ExcAC6A> excAC6ASubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllExcAC6AQuery(),
        ResponseTypes.multipleInstancesOf(ExcAC6A.class),
        ResponseTypes.instanceOf(ExcAC6A.class));
  }

  public SubscriptionQueryResult<ExcAC6A, ExcAC6A> excAC6ASubscribe(
      @DestinationVariable UUID excAC6AId) {
    return queryGateway.subscriptionQuery(
        new FindExcAC6AQuery(new LoadExcAC6AFilter(excAC6AId)),
        ResponseTypes.instanceOf(ExcAC6A.class),
        ResponseTypes.instanceOf(ExcAC6A.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
