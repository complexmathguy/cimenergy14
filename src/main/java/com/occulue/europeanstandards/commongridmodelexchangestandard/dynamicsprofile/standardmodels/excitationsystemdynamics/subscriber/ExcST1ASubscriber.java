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
 * Subscriber for ExcST1A related events. .
 *
 * @author your_name_here
 */
@Component("excST1A-subscriber")
public class ExcST1ASubscriber extends BaseSubscriber {

  public ExcST1ASubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<ExcST1A>, ExcST1A> excST1ASubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllExcST1AQuery(),
        ResponseTypes.multipleInstancesOf(ExcST1A.class),
        ResponseTypes.instanceOf(ExcST1A.class));
  }

  public SubscriptionQueryResult<ExcST1A, ExcST1A> excST1ASubscribe(
      @DestinationVariable UUID excST1AId) {
    return queryGateway.subscriptionQuery(
        new FindExcST1AQuery(new LoadExcST1AFilter(excST1AId)),
        ResponseTypes.instanceOf(ExcST1A.class),
        ResponseTypes.instanceOf(ExcST1A.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
