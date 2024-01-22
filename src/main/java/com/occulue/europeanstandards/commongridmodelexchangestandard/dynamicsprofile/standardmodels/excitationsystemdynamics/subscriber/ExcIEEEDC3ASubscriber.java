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
 * Subscriber for ExcIEEEDC3A related events. .
 *
 * @author your_name_here
 */
@Component("excIEEEDC3A-subscriber")
public class ExcIEEEDC3ASubscriber extends BaseSubscriber {

  public ExcIEEEDC3ASubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<ExcIEEEDC3A>, ExcIEEEDC3A> excIEEEDC3ASubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllExcIEEEDC3AQuery(),
        ResponseTypes.multipleInstancesOf(ExcIEEEDC3A.class),
        ResponseTypes.instanceOf(ExcIEEEDC3A.class));
  }

  public SubscriptionQueryResult<ExcIEEEDC3A, ExcIEEEDC3A> excIEEEDC3ASubscribe(
      @DestinationVariable UUID excIEEEDC3AId) {
    return queryGateway.subscriptionQuery(
        new FindExcIEEEDC3AQuery(new LoadExcIEEEDC3AFilter(excIEEEDC3AId)),
        ResponseTypes.instanceOf(ExcIEEEDC3A.class),
        ResponseTypes.instanceOf(ExcIEEEDC3A.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
