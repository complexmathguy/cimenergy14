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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.dc.subscriber;

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
 * Subscriber for ACDCConverter related events. .
 *
 * @author your_name_here
 */
@Component("aCDCConverter-subscriber")
public class ACDCConverterSubscriber extends BaseSubscriber {

  public ACDCConverterSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<ACDCConverter>, ACDCConverter> aCDCConverterSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllACDCConverterQuery(),
        ResponseTypes.multipleInstancesOf(ACDCConverter.class),
        ResponseTypes.instanceOf(ACDCConverter.class));
  }

  public SubscriptionQueryResult<ACDCConverter, ACDCConverter> aCDCConverterSubscribe(
      @DestinationVariable UUID aCDCConverterId) {
    return queryGateway.subscriptionQuery(
        new FindACDCConverterQuery(new LoadACDCConverterFilter(aCDCConverterId)),
        ResponseTypes.instanceOf(ACDCConverter.class),
        ResponseTypes.instanceOf(ACDCConverter.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
