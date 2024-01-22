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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.discontinuousexcitationcontroldynamics.subscriber;

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
 * Subscriber for DiscExcContIEEEDEC1A related events. .
 *
 * @author your_name_here
 */
@Component("discExcContIEEEDEC1A-subscriber")
public class DiscExcContIEEEDEC1ASubscriber extends BaseSubscriber {

  public DiscExcContIEEEDEC1ASubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<DiscExcContIEEEDEC1A>, DiscExcContIEEEDEC1A>
      discExcContIEEEDEC1ASubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllDiscExcContIEEEDEC1AQuery(),
        ResponseTypes.multipleInstancesOf(DiscExcContIEEEDEC1A.class),
        ResponseTypes.instanceOf(DiscExcContIEEEDEC1A.class));
  }

  public SubscriptionQueryResult<DiscExcContIEEEDEC1A, DiscExcContIEEEDEC1A>
      discExcContIEEEDEC1ASubscribe(@DestinationVariable UUID discExcContIEEEDEC1AId) {
    return queryGateway.subscriptionQuery(
        new FindDiscExcContIEEEDEC1AQuery(
            new LoadDiscExcContIEEEDEC1AFilter(discExcContIEEEDEC1AId)),
        ResponseTypes.instanceOf(DiscExcContIEEEDEC1A.class),
        ResponseTypes.instanceOf(DiscExcContIEEEDEC1A.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
