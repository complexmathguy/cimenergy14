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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.turbinegovernordynamics.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.turbinegovernordynamics.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for GovHydroWEH as outlined for the CQRS pattern. All event handling and query handling
 * related to GovHydroWEH are invoked here and dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by GovHydroWEHAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("govHydroWEH")
@Component("govHydroWEH-projector")
public class GovHydroWEHProjector extends GovHydroWEHEntityProjector {

  // core constructor
  public GovHydroWEHProjector(
      GovHydroWEHRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateGovHydroWEHEvent
   */
  @EventHandler(payloadType = CreateGovHydroWEHEvent.class)
  public void handle(CreateGovHydroWEHEvent event) {
    LOGGER.info("handling CreateGovHydroWEHEvent - " + event);
    GovHydroWEH entity = new GovHydroWEH();
    entity.setGovHydroWEHId(event.getGovHydroWEHId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWEH(entity);
  }

  /*
   * @param	event UpdateGovHydroWEHEvent
   */
  @EventHandler(payloadType = UpdateGovHydroWEHEvent.class)
  public void handle(UpdateGovHydroWEHEvent event) {
    LOGGER.info("handling UpdateGovHydroWEHEvent - " + event);

    GovHydroWEH entity = new GovHydroWEH();
    entity.setGovHydroWEHId(event.getGovHydroWEHId());
    entity.setDb(event.getDb());
    entity.setDicn(event.getDicn());
    entity.setDpv(event.getDpv());
    entity.setDturb(event.getDturb());
    entity.setFeedbackSignal(event.getFeedbackSignal());
    entity.setFl1(event.getFl1());
    entity.setFl2(event.getFl2());
    entity.setFl3(event.getFl3());
    entity.setFl4(event.getFl4());
    entity.setFl5(event.getFl5());
    entity.setFp1(event.getFp1());
    entity.setFp10(event.getFp10());
    entity.setFp2(event.getFp2());
    entity.setFp3(event.getFp3());
    entity.setFp4(event.getFp4());
    entity.setFp5(event.getFp5());
    entity.setFp6(event.getFp6());
    entity.setFp7(event.getFp7());
    entity.setFp8(event.getFp8());
    entity.setFp9(event.getFp9());
    entity.setGmax(event.getGmax());
    entity.setGmin(event.getGmin());
    entity.setGtmxcl(event.getGtmxcl());
    entity.setGtmxop(event.getGtmxop());
    entity.setGv1(event.getGv1());
    entity.setGv2(event.getGv2());
    entity.setGv3(event.getGv3());
    entity.setGv4(event.getGv4());
    entity.setGv5(event.getGv5());
    entity.setKd(event.getKd());
    entity.setKi(event.getKi());
    entity.setKp(event.getKp());
    entity.setMwbase(event.getMwbase());
    entity.setPmss1(event.getPmss1());
    entity.setPmss10(event.getPmss10());
    entity.setPmss2(event.getPmss2());
    entity.setPmss3(event.getPmss3());
    entity.setPmss4(event.getPmss4());
    entity.setPmss5(event.getPmss5());
    entity.setPmss6(event.getPmss6());
    entity.setPmss7(event.getPmss7());
    entity.setPmss8(event.getPmss8());
    entity.setPmss9(event.getPmss9());
    entity.setRpg(event.getRpg());
    entity.setRpp(event.getRpp());
    entity.setTd(event.getTd());
    entity.setTdv(event.getTdv());
    entity.setTg(event.getTg());
    entity.setTp(event.getTp());
    entity.setTpe(event.getTpe());
    entity.setTw(event.getTw());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWEH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWEH(entity);
  }

  /*
   * @param	event DeleteGovHydroWEHEvent
   */
  @EventHandler(payloadType = DeleteGovHydroWEHEvent.class)
  public void handle(DeleteGovHydroWEHEvent event) {
    LOGGER.info("handling DeleteGovHydroWEHEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    GovHydroWEH entity = delete(event.getGovHydroWEHId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWEH(entity);
  }

  /*
   * @param	event AssignDbToGovHydroWEHEvent
   */
  @EventHandler(payloadType = AssignDbToGovHydroWEHEvent.class)
  public void handle(AssignDbToGovHydroWEHEvent event) {
    LOGGER.info("handling AssignDbToGovHydroWEHEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroWEH entity = assignDb(event.getGovHydroWEHId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWEH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWEH(entity);
  }

  /*
   * @param	event UnAssignDbFromGovHydroWEHEvent
   */
  @EventHandler(payloadType = UnAssignDbFromGovHydroWEHEvent.class)
  public void handle(UnAssignDbFromGovHydroWEHEvent event) {
    LOGGER.info("handling UnAssignDbFromGovHydroWEHEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroWEH entity = unAssignDb(event.getGovHydroWEHId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWEH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWEH(entity);
  }

  /*
   * @param	event AssignDicnToGovHydroWEHEvent
   */
  @EventHandler(payloadType = AssignDicnToGovHydroWEHEvent.class)
  public void handle(AssignDicnToGovHydroWEHEvent event) {
    LOGGER.info("handling AssignDicnToGovHydroWEHEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroWEH entity = assignDicn(event.getGovHydroWEHId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWEH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWEH(entity);
  }

  /*
   * @param	event UnAssignDicnFromGovHydroWEHEvent
   */
  @EventHandler(payloadType = UnAssignDicnFromGovHydroWEHEvent.class)
  public void handle(UnAssignDicnFromGovHydroWEHEvent event) {
    LOGGER.info("handling UnAssignDicnFromGovHydroWEHEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroWEH entity = unAssignDicn(event.getGovHydroWEHId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWEH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWEH(entity);
  }

  /*
   * @param	event AssignDpvToGovHydroWEHEvent
   */
  @EventHandler(payloadType = AssignDpvToGovHydroWEHEvent.class)
  public void handle(AssignDpvToGovHydroWEHEvent event) {
    LOGGER.info("handling AssignDpvToGovHydroWEHEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroWEH entity = assignDpv(event.getGovHydroWEHId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWEH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWEH(entity);
  }

  /*
   * @param	event UnAssignDpvFromGovHydroWEHEvent
   */
  @EventHandler(payloadType = UnAssignDpvFromGovHydroWEHEvent.class)
  public void handle(UnAssignDpvFromGovHydroWEHEvent event) {
    LOGGER.info("handling UnAssignDpvFromGovHydroWEHEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroWEH entity = unAssignDpv(event.getGovHydroWEHId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWEH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWEH(entity);
  }

  /*
   * @param	event AssignDturbToGovHydroWEHEvent
   */
  @EventHandler(payloadType = AssignDturbToGovHydroWEHEvent.class)
  public void handle(AssignDturbToGovHydroWEHEvent event) {
    LOGGER.info("handling AssignDturbToGovHydroWEHEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroWEH entity = assignDturb(event.getGovHydroWEHId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWEH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWEH(entity);
  }

  /*
   * @param	event UnAssignDturbFromGovHydroWEHEvent
   */
  @EventHandler(payloadType = UnAssignDturbFromGovHydroWEHEvent.class)
  public void handle(UnAssignDturbFromGovHydroWEHEvent event) {
    LOGGER.info("handling UnAssignDturbFromGovHydroWEHEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroWEH entity = unAssignDturb(event.getGovHydroWEHId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWEH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWEH(entity);
  }

  /*
   * @param	event AssignFeedbackSignalToGovHydroWEHEvent
   */
  @EventHandler(payloadType = AssignFeedbackSignalToGovHydroWEHEvent.class)
  public void handle(AssignFeedbackSignalToGovHydroWEHEvent event) {
    LOGGER.info("handling AssignFeedbackSignalToGovHydroWEHEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroWEH entity = assignFeedbackSignal(event.getGovHydroWEHId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWEH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWEH(entity);
  }

  /*
   * @param	event UnAssignFeedbackSignalFromGovHydroWEHEvent
   */
  @EventHandler(payloadType = UnAssignFeedbackSignalFromGovHydroWEHEvent.class)
  public void handle(UnAssignFeedbackSignalFromGovHydroWEHEvent event) {
    LOGGER.info("handling UnAssignFeedbackSignalFromGovHydroWEHEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroWEH entity = unAssignFeedbackSignal(event.getGovHydroWEHId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWEH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWEH(entity);
  }

  /*
   * @param	event AssignFl1ToGovHydroWEHEvent
   */
  @EventHandler(payloadType = AssignFl1ToGovHydroWEHEvent.class)
  public void handle(AssignFl1ToGovHydroWEHEvent event) {
    LOGGER.info("handling AssignFl1ToGovHydroWEHEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroWEH entity = assignFl1(event.getGovHydroWEHId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWEH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWEH(entity);
  }

  /*
   * @param	event UnAssignFl1FromGovHydroWEHEvent
   */
  @EventHandler(payloadType = UnAssignFl1FromGovHydroWEHEvent.class)
  public void handle(UnAssignFl1FromGovHydroWEHEvent event) {
    LOGGER.info("handling UnAssignFl1FromGovHydroWEHEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroWEH entity = unAssignFl1(event.getGovHydroWEHId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWEH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWEH(entity);
  }

  /*
   * @param	event AssignFl2ToGovHydroWEHEvent
   */
  @EventHandler(payloadType = AssignFl2ToGovHydroWEHEvent.class)
  public void handle(AssignFl2ToGovHydroWEHEvent event) {
    LOGGER.info("handling AssignFl2ToGovHydroWEHEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroWEH entity = assignFl2(event.getGovHydroWEHId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWEH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWEH(entity);
  }

  /*
   * @param	event UnAssignFl2FromGovHydroWEHEvent
   */
  @EventHandler(payloadType = UnAssignFl2FromGovHydroWEHEvent.class)
  public void handle(UnAssignFl2FromGovHydroWEHEvent event) {
    LOGGER.info("handling UnAssignFl2FromGovHydroWEHEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroWEH entity = unAssignFl2(event.getGovHydroWEHId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWEH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWEH(entity);
  }

  /*
   * @param	event AssignFl3ToGovHydroWEHEvent
   */
  @EventHandler(payloadType = AssignFl3ToGovHydroWEHEvent.class)
  public void handle(AssignFl3ToGovHydroWEHEvent event) {
    LOGGER.info("handling AssignFl3ToGovHydroWEHEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroWEH entity = assignFl3(event.getGovHydroWEHId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWEH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWEH(entity);
  }

  /*
   * @param	event UnAssignFl3FromGovHydroWEHEvent
   */
  @EventHandler(payloadType = UnAssignFl3FromGovHydroWEHEvent.class)
  public void handle(UnAssignFl3FromGovHydroWEHEvent event) {
    LOGGER.info("handling UnAssignFl3FromGovHydroWEHEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroWEH entity = unAssignFl3(event.getGovHydroWEHId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWEH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWEH(entity);
  }

  /*
   * @param	event AssignFl4ToGovHydroWEHEvent
   */
  @EventHandler(payloadType = AssignFl4ToGovHydroWEHEvent.class)
  public void handle(AssignFl4ToGovHydroWEHEvent event) {
    LOGGER.info("handling AssignFl4ToGovHydroWEHEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroWEH entity = assignFl4(event.getGovHydroWEHId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWEH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWEH(entity);
  }

  /*
   * @param	event UnAssignFl4FromGovHydroWEHEvent
   */
  @EventHandler(payloadType = UnAssignFl4FromGovHydroWEHEvent.class)
  public void handle(UnAssignFl4FromGovHydroWEHEvent event) {
    LOGGER.info("handling UnAssignFl4FromGovHydroWEHEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroWEH entity = unAssignFl4(event.getGovHydroWEHId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWEH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWEH(entity);
  }

  /*
   * @param	event AssignFl5ToGovHydroWEHEvent
   */
  @EventHandler(payloadType = AssignFl5ToGovHydroWEHEvent.class)
  public void handle(AssignFl5ToGovHydroWEHEvent event) {
    LOGGER.info("handling AssignFl5ToGovHydroWEHEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroWEH entity = assignFl5(event.getGovHydroWEHId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWEH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWEH(entity);
  }

  /*
   * @param	event UnAssignFl5FromGovHydroWEHEvent
   */
  @EventHandler(payloadType = UnAssignFl5FromGovHydroWEHEvent.class)
  public void handle(UnAssignFl5FromGovHydroWEHEvent event) {
    LOGGER.info("handling UnAssignFl5FromGovHydroWEHEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroWEH entity = unAssignFl5(event.getGovHydroWEHId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWEH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWEH(entity);
  }

  /*
   * @param	event AssignFp1ToGovHydroWEHEvent
   */
  @EventHandler(payloadType = AssignFp1ToGovHydroWEHEvent.class)
  public void handle(AssignFp1ToGovHydroWEHEvent event) {
    LOGGER.info("handling AssignFp1ToGovHydroWEHEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroWEH entity = assignFp1(event.getGovHydroWEHId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWEH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWEH(entity);
  }

  /*
   * @param	event UnAssignFp1FromGovHydroWEHEvent
   */
  @EventHandler(payloadType = UnAssignFp1FromGovHydroWEHEvent.class)
  public void handle(UnAssignFp1FromGovHydroWEHEvent event) {
    LOGGER.info("handling UnAssignFp1FromGovHydroWEHEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroWEH entity = unAssignFp1(event.getGovHydroWEHId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWEH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWEH(entity);
  }

  /*
   * @param	event AssignFp10ToGovHydroWEHEvent
   */
  @EventHandler(payloadType = AssignFp10ToGovHydroWEHEvent.class)
  public void handle(AssignFp10ToGovHydroWEHEvent event) {
    LOGGER.info("handling AssignFp10ToGovHydroWEHEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroWEH entity = assignFp10(event.getGovHydroWEHId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWEH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWEH(entity);
  }

  /*
   * @param	event UnAssignFp10FromGovHydroWEHEvent
   */
  @EventHandler(payloadType = UnAssignFp10FromGovHydroWEHEvent.class)
  public void handle(UnAssignFp10FromGovHydroWEHEvent event) {
    LOGGER.info("handling UnAssignFp10FromGovHydroWEHEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroWEH entity = unAssignFp10(event.getGovHydroWEHId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWEH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWEH(entity);
  }

  /*
   * @param	event AssignFp2ToGovHydroWEHEvent
   */
  @EventHandler(payloadType = AssignFp2ToGovHydroWEHEvent.class)
  public void handle(AssignFp2ToGovHydroWEHEvent event) {
    LOGGER.info("handling AssignFp2ToGovHydroWEHEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroWEH entity = assignFp2(event.getGovHydroWEHId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWEH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWEH(entity);
  }

  /*
   * @param	event UnAssignFp2FromGovHydroWEHEvent
   */
  @EventHandler(payloadType = UnAssignFp2FromGovHydroWEHEvent.class)
  public void handle(UnAssignFp2FromGovHydroWEHEvent event) {
    LOGGER.info("handling UnAssignFp2FromGovHydroWEHEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroWEH entity = unAssignFp2(event.getGovHydroWEHId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWEH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWEH(entity);
  }

  /*
   * @param	event AssignFp3ToGovHydroWEHEvent
   */
  @EventHandler(payloadType = AssignFp3ToGovHydroWEHEvent.class)
  public void handle(AssignFp3ToGovHydroWEHEvent event) {
    LOGGER.info("handling AssignFp3ToGovHydroWEHEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroWEH entity = assignFp3(event.getGovHydroWEHId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWEH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWEH(entity);
  }

  /*
   * @param	event UnAssignFp3FromGovHydroWEHEvent
   */
  @EventHandler(payloadType = UnAssignFp3FromGovHydroWEHEvent.class)
  public void handle(UnAssignFp3FromGovHydroWEHEvent event) {
    LOGGER.info("handling UnAssignFp3FromGovHydroWEHEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroWEH entity = unAssignFp3(event.getGovHydroWEHId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWEH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWEH(entity);
  }

  /*
   * @param	event AssignFp4ToGovHydroWEHEvent
   */
  @EventHandler(payloadType = AssignFp4ToGovHydroWEHEvent.class)
  public void handle(AssignFp4ToGovHydroWEHEvent event) {
    LOGGER.info("handling AssignFp4ToGovHydroWEHEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroWEH entity = assignFp4(event.getGovHydroWEHId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWEH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWEH(entity);
  }

  /*
   * @param	event UnAssignFp4FromGovHydroWEHEvent
   */
  @EventHandler(payloadType = UnAssignFp4FromGovHydroWEHEvent.class)
  public void handle(UnAssignFp4FromGovHydroWEHEvent event) {
    LOGGER.info("handling UnAssignFp4FromGovHydroWEHEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroWEH entity = unAssignFp4(event.getGovHydroWEHId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWEH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWEH(entity);
  }

  /*
   * @param	event AssignFp5ToGovHydroWEHEvent
   */
  @EventHandler(payloadType = AssignFp5ToGovHydroWEHEvent.class)
  public void handle(AssignFp5ToGovHydroWEHEvent event) {
    LOGGER.info("handling AssignFp5ToGovHydroWEHEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroWEH entity = assignFp5(event.getGovHydroWEHId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWEH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWEH(entity);
  }

  /*
   * @param	event UnAssignFp5FromGovHydroWEHEvent
   */
  @EventHandler(payloadType = UnAssignFp5FromGovHydroWEHEvent.class)
  public void handle(UnAssignFp5FromGovHydroWEHEvent event) {
    LOGGER.info("handling UnAssignFp5FromGovHydroWEHEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroWEH entity = unAssignFp5(event.getGovHydroWEHId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWEH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWEH(entity);
  }

  /*
   * @param	event AssignFp6ToGovHydroWEHEvent
   */
  @EventHandler(payloadType = AssignFp6ToGovHydroWEHEvent.class)
  public void handle(AssignFp6ToGovHydroWEHEvent event) {
    LOGGER.info("handling AssignFp6ToGovHydroWEHEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroWEH entity = assignFp6(event.getGovHydroWEHId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWEH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWEH(entity);
  }

  /*
   * @param	event UnAssignFp6FromGovHydroWEHEvent
   */
  @EventHandler(payloadType = UnAssignFp6FromGovHydroWEHEvent.class)
  public void handle(UnAssignFp6FromGovHydroWEHEvent event) {
    LOGGER.info("handling UnAssignFp6FromGovHydroWEHEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroWEH entity = unAssignFp6(event.getGovHydroWEHId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWEH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWEH(entity);
  }

  /*
   * @param	event AssignFp7ToGovHydroWEHEvent
   */
  @EventHandler(payloadType = AssignFp7ToGovHydroWEHEvent.class)
  public void handle(AssignFp7ToGovHydroWEHEvent event) {
    LOGGER.info("handling AssignFp7ToGovHydroWEHEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroWEH entity = assignFp7(event.getGovHydroWEHId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWEH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWEH(entity);
  }

  /*
   * @param	event UnAssignFp7FromGovHydroWEHEvent
   */
  @EventHandler(payloadType = UnAssignFp7FromGovHydroWEHEvent.class)
  public void handle(UnAssignFp7FromGovHydroWEHEvent event) {
    LOGGER.info("handling UnAssignFp7FromGovHydroWEHEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroWEH entity = unAssignFp7(event.getGovHydroWEHId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWEH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWEH(entity);
  }

  /*
   * @param	event AssignFp8ToGovHydroWEHEvent
   */
  @EventHandler(payloadType = AssignFp8ToGovHydroWEHEvent.class)
  public void handle(AssignFp8ToGovHydroWEHEvent event) {
    LOGGER.info("handling AssignFp8ToGovHydroWEHEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroWEH entity = assignFp8(event.getGovHydroWEHId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWEH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWEH(entity);
  }

  /*
   * @param	event UnAssignFp8FromGovHydroWEHEvent
   */
  @EventHandler(payloadType = UnAssignFp8FromGovHydroWEHEvent.class)
  public void handle(UnAssignFp8FromGovHydroWEHEvent event) {
    LOGGER.info("handling UnAssignFp8FromGovHydroWEHEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroWEH entity = unAssignFp8(event.getGovHydroWEHId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWEH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWEH(entity);
  }

  /*
   * @param	event AssignFp9ToGovHydroWEHEvent
   */
  @EventHandler(payloadType = AssignFp9ToGovHydroWEHEvent.class)
  public void handle(AssignFp9ToGovHydroWEHEvent event) {
    LOGGER.info("handling AssignFp9ToGovHydroWEHEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroWEH entity = assignFp9(event.getGovHydroWEHId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWEH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWEH(entity);
  }

  /*
   * @param	event UnAssignFp9FromGovHydroWEHEvent
   */
  @EventHandler(payloadType = UnAssignFp9FromGovHydroWEHEvent.class)
  public void handle(UnAssignFp9FromGovHydroWEHEvent event) {
    LOGGER.info("handling UnAssignFp9FromGovHydroWEHEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroWEH entity = unAssignFp9(event.getGovHydroWEHId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWEH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWEH(entity);
  }

  /*
   * @param	event AssignGmaxToGovHydroWEHEvent
   */
  @EventHandler(payloadType = AssignGmaxToGovHydroWEHEvent.class)
  public void handle(AssignGmaxToGovHydroWEHEvent event) {
    LOGGER.info("handling AssignGmaxToGovHydroWEHEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroWEH entity = assignGmax(event.getGovHydroWEHId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWEH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWEH(entity);
  }

  /*
   * @param	event UnAssignGmaxFromGovHydroWEHEvent
   */
  @EventHandler(payloadType = UnAssignGmaxFromGovHydroWEHEvent.class)
  public void handle(UnAssignGmaxFromGovHydroWEHEvent event) {
    LOGGER.info("handling UnAssignGmaxFromGovHydroWEHEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroWEH entity = unAssignGmax(event.getGovHydroWEHId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWEH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWEH(entity);
  }

  /*
   * @param	event AssignGminToGovHydroWEHEvent
   */
  @EventHandler(payloadType = AssignGminToGovHydroWEHEvent.class)
  public void handle(AssignGminToGovHydroWEHEvent event) {
    LOGGER.info("handling AssignGminToGovHydroWEHEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroWEH entity = assignGmin(event.getGovHydroWEHId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWEH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWEH(entity);
  }

  /*
   * @param	event UnAssignGminFromGovHydroWEHEvent
   */
  @EventHandler(payloadType = UnAssignGminFromGovHydroWEHEvent.class)
  public void handle(UnAssignGminFromGovHydroWEHEvent event) {
    LOGGER.info("handling UnAssignGminFromGovHydroWEHEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroWEH entity = unAssignGmin(event.getGovHydroWEHId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWEH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWEH(entity);
  }

  /*
   * @param	event AssignGtmxclToGovHydroWEHEvent
   */
  @EventHandler(payloadType = AssignGtmxclToGovHydroWEHEvent.class)
  public void handle(AssignGtmxclToGovHydroWEHEvent event) {
    LOGGER.info("handling AssignGtmxclToGovHydroWEHEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroWEH entity = assignGtmxcl(event.getGovHydroWEHId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWEH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWEH(entity);
  }

  /*
   * @param	event UnAssignGtmxclFromGovHydroWEHEvent
   */
  @EventHandler(payloadType = UnAssignGtmxclFromGovHydroWEHEvent.class)
  public void handle(UnAssignGtmxclFromGovHydroWEHEvent event) {
    LOGGER.info("handling UnAssignGtmxclFromGovHydroWEHEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroWEH entity = unAssignGtmxcl(event.getGovHydroWEHId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWEH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWEH(entity);
  }

  /*
   * @param	event AssignGtmxopToGovHydroWEHEvent
   */
  @EventHandler(payloadType = AssignGtmxopToGovHydroWEHEvent.class)
  public void handle(AssignGtmxopToGovHydroWEHEvent event) {
    LOGGER.info("handling AssignGtmxopToGovHydroWEHEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroWEH entity = assignGtmxop(event.getGovHydroWEHId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWEH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWEH(entity);
  }

  /*
   * @param	event UnAssignGtmxopFromGovHydroWEHEvent
   */
  @EventHandler(payloadType = UnAssignGtmxopFromGovHydroWEHEvent.class)
  public void handle(UnAssignGtmxopFromGovHydroWEHEvent event) {
    LOGGER.info("handling UnAssignGtmxopFromGovHydroWEHEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroWEH entity = unAssignGtmxop(event.getGovHydroWEHId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWEH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWEH(entity);
  }

  /*
   * @param	event AssignGv1ToGovHydroWEHEvent
   */
  @EventHandler(payloadType = AssignGv1ToGovHydroWEHEvent.class)
  public void handle(AssignGv1ToGovHydroWEHEvent event) {
    LOGGER.info("handling AssignGv1ToGovHydroWEHEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroWEH entity = assignGv1(event.getGovHydroWEHId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWEH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWEH(entity);
  }

  /*
   * @param	event UnAssignGv1FromGovHydroWEHEvent
   */
  @EventHandler(payloadType = UnAssignGv1FromGovHydroWEHEvent.class)
  public void handle(UnAssignGv1FromGovHydroWEHEvent event) {
    LOGGER.info("handling UnAssignGv1FromGovHydroWEHEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroWEH entity = unAssignGv1(event.getGovHydroWEHId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWEH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWEH(entity);
  }

  /*
   * @param	event AssignGv2ToGovHydroWEHEvent
   */
  @EventHandler(payloadType = AssignGv2ToGovHydroWEHEvent.class)
  public void handle(AssignGv2ToGovHydroWEHEvent event) {
    LOGGER.info("handling AssignGv2ToGovHydroWEHEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroWEH entity = assignGv2(event.getGovHydroWEHId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWEH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWEH(entity);
  }

  /*
   * @param	event UnAssignGv2FromGovHydroWEHEvent
   */
  @EventHandler(payloadType = UnAssignGv2FromGovHydroWEHEvent.class)
  public void handle(UnAssignGv2FromGovHydroWEHEvent event) {
    LOGGER.info("handling UnAssignGv2FromGovHydroWEHEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroWEH entity = unAssignGv2(event.getGovHydroWEHId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWEH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWEH(entity);
  }

  /*
   * @param	event AssignGv3ToGovHydroWEHEvent
   */
  @EventHandler(payloadType = AssignGv3ToGovHydroWEHEvent.class)
  public void handle(AssignGv3ToGovHydroWEHEvent event) {
    LOGGER.info("handling AssignGv3ToGovHydroWEHEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroWEH entity = assignGv3(event.getGovHydroWEHId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWEH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWEH(entity);
  }

  /*
   * @param	event UnAssignGv3FromGovHydroWEHEvent
   */
  @EventHandler(payloadType = UnAssignGv3FromGovHydroWEHEvent.class)
  public void handle(UnAssignGv3FromGovHydroWEHEvent event) {
    LOGGER.info("handling UnAssignGv3FromGovHydroWEHEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroWEH entity = unAssignGv3(event.getGovHydroWEHId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWEH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWEH(entity);
  }

  /*
   * @param	event AssignGv4ToGovHydroWEHEvent
   */
  @EventHandler(payloadType = AssignGv4ToGovHydroWEHEvent.class)
  public void handle(AssignGv4ToGovHydroWEHEvent event) {
    LOGGER.info("handling AssignGv4ToGovHydroWEHEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroWEH entity = assignGv4(event.getGovHydroWEHId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWEH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWEH(entity);
  }

  /*
   * @param	event UnAssignGv4FromGovHydroWEHEvent
   */
  @EventHandler(payloadType = UnAssignGv4FromGovHydroWEHEvent.class)
  public void handle(UnAssignGv4FromGovHydroWEHEvent event) {
    LOGGER.info("handling UnAssignGv4FromGovHydroWEHEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroWEH entity = unAssignGv4(event.getGovHydroWEHId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWEH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWEH(entity);
  }

  /*
   * @param	event AssignGv5ToGovHydroWEHEvent
   */
  @EventHandler(payloadType = AssignGv5ToGovHydroWEHEvent.class)
  public void handle(AssignGv5ToGovHydroWEHEvent event) {
    LOGGER.info("handling AssignGv5ToGovHydroWEHEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroWEH entity = assignGv5(event.getGovHydroWEHId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWEH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWEH(entity);
  }

  /*
   * @param	event UnAssignGv5FromGovHydroWEHEvent
   */
  @EventHandler(payloadType = UnAssignGv5FromGovHydroWEHEvent.class)
  public void handle(UnAssignGv5FromGovHydroWEHEvent event) {
    LOGGER.info("handling UnAssignGv5FromGovHydroWEHEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroWEH entity = unAssignGv5(event.getGovHydroWEHId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWEH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWEH(entity);
  }

  /*
   * @param	event AssignKdToGovHydroWEHEvent
   */
  @EventHandler(payloadType = AssignKdToGovHydroWEHEvent.class)
  public void handle(AssignKdToGovHydroWEHEvent event) {
    LOGGER.info("handling AssignKdToGovHydroWEHEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroWEH entity = assignKd(event.getGovHydroWEHId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWEH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWEH(entity);
  }

  /*
   * @param	event UnAssignKdFromGovHydroWEHEvent
   */
  @EventHandler(payloadType = UnAssignKdFromGovHydroWEHEvent.class)
  public void handle(UnAssignKdFromGovHydroWEHEvent event) {
    LOGGER.info("handling UnAssignKdFromGovHydroWEHEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroWEH entity = unAssignKd(event.getGovHydroWEHId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWEH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWEH(entity);
  }

  /*
   * @param	event AssignKiToGovHydroWEHEvent
   */
  @EventHandler(payloadType = AssignKiToGovHydroWEHEvent.class)
  public void handle(AssignKiToGovHydroWEHEvent event) {
    LOGGER.info("handling AssignKiToGovHydroWEHEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroWEH entity = assignKi(event.getGovHydroWEHId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWEH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWEH(entity);
  }

  /*
   * @param	event UnAssignKiFromGovHydroWEHEvent
   */
  @EventHandler(payloadType = UnAssignKiFromGovHydroWEHEvent.class)
  public void handle(UnAssignKiFromGovHydroWEHEvent event) {
    LOGGER.info("handling UnAssignKiFromGovHydroWEHEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroWEH entity = unAssignKi(event.getGovHydroWEHId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWEH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWEH(entity);
  }

  /*
   * @param	event AssignKpToGovHydroWEHEvent
   */
  @EventHandler(payloadType = AssignKpToGovHydroWEHEvent.class)
  public void handle(AssignKpToGovHydroWEHEvent event) {
    LOGGER.info("handling AssignKpToGovHydroWEHEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroWEH entity = assignKp(event.getGovHydroWEHId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWEH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWEH(entity);
  }

  /*
   * @param	event UnAssignKpFromGovHydroWEHEvent
   */
  @EventHandler(payloadType = UnAssignKpFromGovHydroWEHEvent.class)
  public void handle(UnAssignKpFromGovHydroWEHEvent event) {
    LOGGER.info("handling UnAssignKpFromGovHydroWEHEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroWEH entity = unAssignKp(event.getGovHydroWEHId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWEH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWEH(entity);
  }

  /*
   * @param	event AssignMwbaseToGovHydroWEHEvent
   */
  @EventHandler(payloadType = AssignMwbaseToGovHydroWEHEvent.class)
  public void handle(AssignMwbaseToGovHydroWEHEvent event) {
    LOGGER.info("handling AssignMwbaseToGovHydroWEHEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroWEH entity = assignMwbase(event.getGovHydroWEHId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWEH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWEH(entity);
  }

  /*
   * @param	event UnAssignMwbaseFromGovHydroWEHEvent
   */
  @EventHandler(payloadType = UnAssignMwbaseFromGovHydroWEHEvent.class)
  public void handle(UnAssignMwbaseFromGovHydroWEHEvent event) {
    LOGGER.info("handling UnAssignMwbaseFromGovHydroWEHEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroWEH entity = unAssignMwbase(event.getGovHydroWEHId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWEH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWEH(entity);
  }

  /*
   * @param	event AssignPmss1ToGovHydroWEHEvent
   */
  @EventHandler(payloadType = AssignPmss1ToGovHydroWEHEvent.class)
  public void handle(AssignPmss1ToGovHydroWEHEvent event) {
    LOGGER.info("handling AssignPmss1ToGovHydroWEHEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroWEH entity = assignPmss1(event.getGovHydroWEHId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWEH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWEH(entity);
  }

  /*
   * @param	event UnAssignPmss1FromGovHydroWEHEvent
   */
  @EventHandler(payloadType = UnAssignPmss1FromGovHydroWEHEvent.class)
  public void handle(UnAssignPmss1FromGovHydroWEHEvent event) {
    LOGGER.info("handling UnAssignPmss1FromGovHydroWEHEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroWEH entity = unAssignPmss1(event.getGovHydroWEHId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWEH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWEH(entity);
  }

  /*
   * @param	event AssignPmss10ToGovHydroWEHEvent
   */
  @EventHandler(payloadType = AssignPmss10ToGovHydroWEHEvent.class)
  public void handle(AssignPmss10ToGovHydroWEHEvent event) {
    LOGGER.info("handling AssignPmss10ToGovHydroWEHEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroWEH entity = assignPmss10(event.getGovHydroWEHId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWEH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWEH(entity);
  }

  /*
   * @param	event UnAssignPmss10FromGovHydroWEHEvent
   */
  @EventHandler(payloadType = UnAssignPmss10FromGovHydroWEHEvent.class)
  public void handle(UnAssignPmss10FromGovHydroWEHEvent event) {
    LOGGER.info("handling UnAssignPmss10FromGovHydroWEHEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroWEH entity = unAssignPmss10(event.getGovHydroWEHId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWEH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWEH(entity);
  }

  /*
   * @param	event AssignPmss2ToGovHydroWEHEvent
   */
  @EventHandler(payloadType = AssignPmss2ToGovHydroWEHEvent.class)
  public void handle(AssignPmss2ToGovHydroWEHEvent event) {
    LOGGER.info("handling AssignPmss2ToGovHydroWEHEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroWEH entity = assignPmss2(event.getGovHydroWEHId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWEH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWEH(entity);
  }

  /*
   * @param	event UnAssignPmss2FromGovHydroWEHEvent
   */
  @EventHandler(payloadType = UnAssignPmss2FromGovHydroWEHEvent.class)
  public void handle(UnAssignPmss2FromGovHydroWEHEvent event) {
    LOGGER.info("handling UnAssignPmss2FromGovHydroWEHEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroWEH entity = unAssignPmss2(event.getGovHydroWEHId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWEH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWEH(entity);
  }

  /*
   * @param	event AssignPmss3ToGovHydroWEHEvent
   */
  @EventHandler(payloadType = AssignPmss3ToGovHydroWEHEvent.class)
  public void handle(AssignPmss3ToGovHydroWEHEvent event) {
    LOGGER.info("handling AssignPmss3ToGovHydroWEHEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroWEH entity = assignPmss3(event.getGovHydroWEHId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWEH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWEH(entity);
  }

  /*
   * @param	event UnAssignPmss3FromGovHydroWEHEvent
   */
  @EventHandler(payloadType = UnAssignPmss3FromGovHydroWEHEvent.class)
  public void handle(UnAssignPmss3FromGovHydroWEHEvent event) {
    LOGGER.info("handling UnAssignPmss3FromGovHydroWEHEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroWEH entity = unAssignPmss3(event.getGovHydroWEHId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWEH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWEH(entity);
  }

  /*
   * @param	event AssignPmss4ToGovHydroWEHEvent
   */
  @EventHandler(payloadType = AssignPmss4ToGovHydroWEHEvent.class)
  public void handle(AssignPmss4ToGovHydroWEHEvent event) {
    LOGGER.info("handling AssignPmss4ToGovHydroWEHEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroWEH entity = assignPmss4(event.getGovHydroWEHId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWEH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWEH(entity);
  }

  /*
   * @param	event UnAssignPmss4FromGovHydroWEHEvent
   */
  @EventHandler(payloadType = UnAssignPmss4FromGovHydroWEHEvent.class)
  public void handle(UnAssignPmss4FromGovHydroWEHEvent event) {
    LOGGER.info("handling UnAssignPmss4FromGovHydroWEHEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroWEH entity = unAssignPmss4(event.getGovHydroWEHId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWEH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWEH(entity);
  }

  /*
   * @param	event AssignPmss5ToGovHydroWEHEvent
   */
  @EventHandler(payloadType = AssignPmss5ToGovHydroWEHEvent.class)
  public void handle(AssignPmss5ToGovHydroWEHEvent event) {
    LOGGER.info("handling AssignPmss5ToGovHydroWEHEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroWEH entity = assignPmss5(event.getGovHydroWEHId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWEH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWEH(entity);
  }

  /*
   * @param	event UnAssignPmss5FromGovHydroWEHEvent
   */
  @EventHandler(payloadType = UnAssignPmss5FromGovHydroWEHEvent.class)
  public void handle(UnAssignPmss5FromGovHydroWEHEvent event) {
    LOGGER.info("handling UnAssignPmss5FromGovHydroWEHEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroWEH entity = unAssignPmss5(event.getGovHydroWEHId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWEH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWEH(entity);
  }

  /*
   * @param	event AssignPmss6ToGovHydroWEHEvent
   */
  @EventHandler(payloadType = AssignPmss6ToGovHydroWEHEvent.class)
  public void handle(AssignPmss6ToGovHydroWEHEvent event) {
    LOGGER.info("handling AssignPmss6ToGovHydroWEHEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroWEH entity = assignPmss6(event.getGovHydroWEHId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWEH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWEH(entity);
  }

  /*
   * @param	event UnAssignPmss6FromGovHydroWEHEvent
   */
  @EventHandler(payloadType = UnAssignPmss6FromGovHydroWEHEvent.class)
  public void handle(UnAssignPmss6FromGovHydroWEHEvent event) {
    LOGGER.info("handling UnAssignPmss6FromGovHydroWEHEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroWEH entity = unAssignPmss6(event.getGovHydroWEHId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWEH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWEH(entity);
  }

  /*
   * @param	event AssignPmss7ToGovHydroWEHEvent
   */
  @EventHandler(payloadType = AssignPmss7ToGovHydroWEHEvent.class)
  public void handle(AssignPmss7ToGovHydroWEHEvent event) {
    LOGGER.info("handling AssignPmss7ToGovHydroWEHEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroWEH entity = assignPmss7(event.getGovHydroWEHId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWEH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWEH(entity);
  }

  /*
   * @param	event UnAssignPmss7FromGovHydroWEHEvent
   */
  @EventHandler(payloadType = UnAssignPmss7FromGovHydroWEHEvent.class)
  public void handle(UnAssignPmss7FromGovHydroWEHEvent event) {
    LOGGER.info("handling UnAssignPmss7FromGovHydroWEHEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroWEH entity = unAssignPmss7(event.getGovHydroWEHId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWEH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWEH(entity);
  }

  /*
   * @param	event AssignPmss8ToGovHydroWEHEvent
   */
  @EventHandler(payloadType = AssignPmss8ToGovHydroWEHEvent.class)
  public void handle(AssignPmss8ToGovHydroWEHEvent event) {
    LOGGER.info("handling AssignPmss8ToGovHydroWEHEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroWEH entity = assignPmss8(event.getGovHydroWEHId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWEH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWEH(entity);
  }

  /*
   * @param	event UnAssignPmss8FromGovHydroWEHEvent
   */
  @EventHandler(payloadType = UnAssignPmss8FromGovHydroWEHEvent.class)
  public void handle(UnAssignPmss8FromGovHydroWEHEvent event) {
    LOGGER.info("handling UnAssignPmss8FromGovHydroWEHEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroWEH entity = unAssignPmss8(event.getGovHydroWEHId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWEH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWEH(entity);
  }

  /*
   * @param	event AssignPmss9ToGovHydroWEHEvent
   */
  @EventHandler(payloadType = AssignPmss9ToGovHydroWEHEvent.class)
  public void handle(AssignPmss9ToGovHydroWEHEvent event) {
    LOGGER.info("handling AssignPmss9ToGovHydroWEHEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroWEH entity = assignPmss9(event.getGovHydroWEHId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWEH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWEH(entity);
  }

  /*
   * @param	event UnAssignPmss9FromGovHydroWEHEvent
   */
  @EventHandler(payloadType = UnAssignPmss9FromGovHydroWEHEvent.class)
  public void handle(UnAssignPmss9FromGovHydroWEHEvent event) {
    LOGGER.info("handling UnAssignPmss9FromGovHydroWEHEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroWEH entity = unAssignPmss9(event.getGovHydroWEHId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWEH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWEH(entity);
  }

  /*
   * @param	event AssignRpgToGovHydroWEHEvent
   */
  @EventHandler(payloadType = AssignRpgToGovHydroWEHEvent.class)
  public void handle(AssignRpgToGovHydroWEHEvent event) {
    LOGGER.info("handling AssignRpgToGovHydroWEHEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroWEH entity = assignRpg(event.getGovHydroWEHId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWEH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWEH(entity);
  }

  /*
   * @param	event UnAssignRpgFromGovHydroWEHEvent
   */
  @EventHandler(payloadType = UnAssignRpgFromGovHydroWEHEvent.class)
  public void handle(UnAssignRpgFromGovHydroWEHEvent event) {
    LOGGER.info("handling UnAssignRpgFromGovHydroWEHEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroWEH entity = unAssignRpg(event.getGovHydroWEHId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWEH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWEH(entity);
  }

  /*
   * @param	event AssignRppToGovHydroWEHEvent
   */
  @EventHandler(payloadType = AssignRppToGovHydroWEHEvent.class)
  public void handle(AssignRppToGovHydroWEHEvent event) {
    LOGGER.info("handling AssignRppToGovHydroWEHEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroWEH entity = assignRpp(event.getGovHydroWEHId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWEH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWEH(entity);
  }

  /*
   * @param	event UnAssignRppFromGovHydroWEHEvent
   */
  @EventHandler(payloadType = UnAssignRppFromGovHydroWEHEvent.class)
  public void handle(UnAssignRppFromGovHydroWEHEvent event) {
    LOGGER.info("handling UnAssignRppFromGovHydroWEHEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroWEH entity = unAssignRpp(event.getGovHydroWEHId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWEH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWEH(entity);
  }

  /*
   * @param	event AssignTdToGovHydroWEHEvent
   */
  @EventHandler(payloadType = AssignTdToGovHydroWEHEvent.class)
  public void handle(AssignTdToGovHydroWEHEvent event) {
    LOGGER.info("handling AssignTdToGovHydroWEHEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroWEH entity = assignTd(event.getGovHydroWEHId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWEH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWEH(entity);
  }

  /*
   * @param	event UnAssignTdFromGovHydroWEHEvent
   */
  @EventHandler(payloadType = UnAssignTdFromGovHydroWEHEvent.class)
  public void handle(UnAssignTdFromGovHydroWEHEvent event) {
    LOGGER.info("handling UnAssignTdFromGovHydroWEHEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroWEH entity = unAssignTd(event.getGovHydroWEHId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWEH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWEH(entity);
  }

  /*
   * @param	event AssignTdvToGovHydroWEHEvent
   */
  @EventHandler(payloadType = AssignTdvToGovHydroWEHEvent.class)
  public void handle(AssignTdvToGovHydroWEHEvent event) {
    LOGGER.info("handling AssignTdvToGovHydroWEHEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroWEH entity = assignTdv(event.getGovHydroWEHId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWEH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWEH(entity);
  }

  /*
   * @param	event UnAssignTdvFromGovHydroWEHEvent
   */
  @EventHandler(payloadType = UnAssignTdvFromGovHydroWEHEvent.class)
  public void handle(UnAssignTdvFromGovHydroWEHEvent event) {
    LOGGER.info("handling UnAssignTdvFromGovHydroWEHEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroWEH entity = unAssignTdv(event.getGovHydroWEHId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWEH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWEH(entity);
  }

  /*
   * @param	event AssignTgToGovHydroWEHEvent
   */
  @EventHandler(payloadType = AssignTgToGovHydroWEHEvent.class)
  public void handle(AssignTgToGovHydroWEHEvent event) {
    LOGGER.info("handling AssignTgToGovHydroWEHEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroWEH entity = assignTg(event.getGovHydroWEHId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWEH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWEH(entity);
  }

  /*
   * @param	event UnAssignTgFromGovHydroWEHEvent
   */
  @EventHandler(payloadType = UnAssignTgFromGovHydroWEHEvent.class)
  public void handle(UnAssignTgFromGovHydroWEHEvent event) {
    LOGGER.info("handling UnAssignTgFromGovHydroWEHEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroWEH entity = unAssignTg(event.getGovHydroWEHId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWEH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWEH(entity);
  }

  /*
   * @param	event AssignTpToGovHydroWEHEvent
   */
  @EventHandler(payloadType = AssignTpToGovHydroWEHEvent.class)
  public void handle(AssignTpToGovHydroWEHEvent event) {
    LOGGER.info("handling AssignTpToGovHydroWEHEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroWEH entity = assignTp(event.getGovHydroWEHId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWEH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWEH(entity);
  }

  /*
   * @param	event UnAssignTpFromGovHydroWEHEvent
   */
  @EventHandler(payloadType = UnAssignTpFromGovHydroWEHEvent.class)
  public void handle(UnAssignTpFromGovHydroWEHEvent event) {
    LOGGER.info("handling UnAssignTpFromGovHydroWEHEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroWEH entity = unAssignTp(event.getGovHydroWEHId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWEH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWEH(entity);
  }

  /*
   * @param	event AssignTpeToGovHydroWEHEvent
   */
  @EventHandler(payloadType = AssignTpeToGovHydroWEHEvent.class)
  public void handle(AssignTpeToGovHydroWEHEvent event) {
    LOGGER.info("handling AssignTpeToGovHydroWEHEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroWEH entity = assignTpe(event.getGovHydroWEHId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWEH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWEH(entity);
  }

  /*
   * @param	event UnAssignTpeFromGovHydroWEHEvent
   */
  @EventHandler(payloadType = UnAssignTpeFromGovHydroWEHEvent.class)
  public void handle(UnAssignTpeFromGovHydroWEHEvent event) {
    LOGGER.info("handling UnAssignTpeFromGovHydroWEHEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroWEH entity = unAssignTpe(event.getGovHydroWEHId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWEH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWEH(entity);
  }

  /*
   * @param	event AssignTwToGovHydroWEHEvent
   */
  @EventHandler(payloadType = AssignTwToGovHydroWEHEvent.class)
  public void handle(AssignTwToGovHydroWEHEvent event) {
    LOGGER.info("handling AssignTwToGovHydroWEHEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroWEH entity = assignTw(event.getGovHydroWEHId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWEH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWEH(entity);
  }

  /*
   * @param	event UnAssignTwFromGovHydroWEHEvent
   */
  @EventHandler(payloadType = UnAssignTwFromGovHydroWEHEvent.class)
  public void handle(UnAssignTwFromGovHydroWEHEvent event) {
    LOGGER.info("handling UnAssignTwFromGovHydroWEHEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroWEH entity = unAssignTw(event.getGovHydroWEHId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWEH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWEH(entity);
  }

  /**
   * Method to retrieve the GovHydroWEH via an GovHydroWEHPrimaryKey.
   *
   * @param id Long
   * @return GovHydroWEH
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public GovHydroWEH handle(FindGovHydroWEHQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getGovHydroWEHId());
  }

  /**
   * Method to retrieve a collection of all GovHydroWEHs
   *
   * @param query FindAllGovHydroWEHQuery
   * @return List<GovHydroWEH>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<GovHydroWEH> handle(FindAllGovHydroWEHQuery query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindGovHydroWEH, but only if the id matches
   *
   * @param entity GovHydroWEH
   */
  protected void emitFindGovHydroWEH(GovHydroWEH entity) {
    LOGGER.info("handling emitFindGovHydroWEH");

    queryUpdateEmitter.emit(
        FindGovHydroWEHQuery.class,
        query -> query.getFilter().getGovHydroWEHId().equals(entity.getGovHydroWEHId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllGovHydroWEH
   *
   * @param entity GovHydroWEH
   */
  protected void emitFindAllGovHydroWEH(GovHydroWEH entity) {
    LOGGER.info("handling emitFindAllGovHydroWEH");

    queryUpdateEmitter.emit(FindAllGovHydroWEHQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(GovHydroWEHProjector.class.getName());
}
