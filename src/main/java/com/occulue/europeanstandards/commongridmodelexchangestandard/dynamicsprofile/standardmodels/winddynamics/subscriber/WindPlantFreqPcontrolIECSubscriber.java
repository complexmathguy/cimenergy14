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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.winddynamics.subscriber;

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
 * Subscriber for WindPlantFreqPcontrolIEC related events. .
 *
 * @author your_name_here
 */
@Component("windPlantFreqPcontrolIEC-subscriber")
public class WindPlantFreqPcontrolIECSubscriber extends BaseSubscriber {

  public WindPlantFreqPcontrolIECSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<WindPlantFreqPcontrolIEC>, WindPlantFreqPcontrolIEC>
      windPlantFreqPcontrolIECSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllWindPlantFreqPcontrolIECQuery(),
        ResponseTypes.multipleInstancesOf(WindPlantFreqPcontrolIEC.class),
        ResponseTypes.instanceOf(WindPlantFreqPcontrolIEC.class));
  }

  public SubscriptionQueryResult<WindPlantFreqPcontrolIEC, WindPlantFreqPcontrolIEC>
      windPlantFreqPcontrolIECSubscribe(@DestinationVariable UUID windPlantFreqPcontrolIECId) {
    return queryGateway.subscriptionQuery(
        new FindWindPlantFreqPcontrolIECQuery(
            new LoadWindPlantFreqPcontrolIECFilter(windPlantFreqPcontrolIECId)),
        ResponseTypes.instanceOf(WindPlantFreqPcontrolIEC.class),
        ResponseTypes.instanceOf(WindPlantFreqPcontrolIEC.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
