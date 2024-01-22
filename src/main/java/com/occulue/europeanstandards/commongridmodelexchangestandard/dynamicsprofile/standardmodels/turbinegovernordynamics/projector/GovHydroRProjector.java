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
 * Projector for GovHydroR as outlined for the CQRS pattern. All event handling and query handling
 * related to GovHydroR are invoked here and dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by GovHydroRAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("govHydroR")
@Component("govHydroR-projector")
public class GovHydroRProjector extends GovHydroREntityProjector {

  // core constructor
  public GovHydroRProjector(GovHydroRRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateGovHydroREvent
   */
  @EventHandler(payloadType = CreateGovHydroREvent.class)
  public void handle(CreateGovHydroREvent event) {
    LOGGER.info("handling CreateGovHydroREvent - " + event);
    GovHydroR entity = new GovHydroR();
    entity.setGovHydroRId(event.getGovHydroRId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroR(entity);
  }

  /*
   * @param	event UpdateGovHydroREvent
   */
  @EventHandler(payloadType = UpdateGovHydroREvent.class)
  public void handle(UpdateGovHydroREvent event) {
    LOGGER.info("handling UpdateGovHydroREvent - " + event);

    GovHydroR entity = new GovHydroR();
    entity.setGovHydroRId(event.getGovHydroRId());
    entity.setAt(event.getAt());
    entity.setDb1(event.getDb1());
    entity.setDb2(event.getDb2());
    entity.setDturb(event.getDturb());
    entity.setEps(event.getEps());
    entity.setGmax(event.getGmax());
    entity.setGmin(event.getGmin());
    entity.setGv1(event.getGv1());
    entity.setGv2(event.getGv2());
    entity.setGv3(event.getGv3());
    entity.setGv4(event.getGv4());
    entity.setGv5(event.getGv5());
    entity.setGv6(event.getGv6());
    entity.setH0(event.getH0());
    entity.setInputSignal(event.getInputSignal());
    entity.setKg(event.getKg());
    entity.setKi(event.getKi());
    entity.setMwbase(event.getMwbase());
    entity.setPgv1(event.getPgv1());
    entity.setPgv2(event.getPgv2());
    entity.setPgv3(event.getPgv3());
    entity.setPgv4(event.getPgv4());
    entity.setPgv5(event.getPgv5());
    entity.setPgv6(event.getPgv6());
    entity.setPmax(event.getPmax());
    entity.setPmin(event.getPmin());
    entity.setQnl(event.getQnl());
    entity.setR(event.getR());
    entity.setT1(event.getT1());
    entity.setT2(event.getT2());
    entity.setT3(event.getT3());
    entity.setT4(event.getT4());
    entity.setT5(event.getT5());
    entity.setT6(event.getT6());
    entity.setT7(event.getT7());
    entity.setT8(event.getT8());
    entity.setTd(event.getTd());
    entity.setTp(event.getTp());
    entity.setTt(event.getTt());
    entity.setTw(event.getTw());
    entity.setVelcl(event.getVelcl());
    entity.setVelop(event.getVelop());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroR(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroR(entity);
  }

  /*
   * @param	event DeleteGovHydroREvent
   */
  @EventHandler(payloadType = DeleteGovHydroREvent.class)
  public void handle(DeleteGovHydroREvent event) {
    LOGGER.info("handling DeleteGovHydroREvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    GovHydroR entity = delete(event.getGovHydroRId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroR(entity);
  }

  /*
   * @param	event AssignAtToGovHydroREvent
   */
  @EventHandler(payloadType = AssignAtToGovHydroREvent.class)
  public void handle(AssignAtToGovHydroREvent event) {
    LOGGER.info("handling AssignAtToGovHydroREvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroR entity = assignAt(event.getGovHydroRId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroR(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroR(entity);
  }

  /*
   * @param	event UnAssignAtFromGovHydroREvent
   */
  @EventHandler(payloadType = UnAssignAtFromGovHydroREvent.class)
  public void handle(UnAssignAtFromGovHydroREvent event) {
    LOGGER.info("handling UnAssignAtFromGovHydroREvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroR entity = unAssignAt(event.getGovHydroRId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroR(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroR(entity);
  }

  /*
   * @param	event AssignDb1ToGovHydroREvent
   */
  @EventHandler(payloadType = AssignDb1ToGovHydroREvent.class)
  public void handle(AssignDb1ToGovHydroREvent event) {
    LOGGER.info("handling AssignDb1ToGovHydroREvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroR entity = assignDb1(event.getGovHydroRId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroR(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroR(entity);
  }

  /*
   * @param	event UnAssignDb1FromGovHydroREvent
   */
  @EventHandler(payloadType = UnAssignDb1FromGovHydroREvent.class)
  public void handle(UnAssignDb1FromGovHydroREvent event) {
    LOGGER.info("handling UnAssignDb1FromGovHydroREvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroR entity = unAssignDb1(event.getGovHydroRId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroR(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroR(entity);
  }

  /*
   * @param	event AssignDb2ToGovHydroREvent
   */
  @EventHandler(payloadType = AssignDb2ToGovHydroREvent.class)
  public void handle(AssignDb2ToGovHydroREvent event) {
    LOGGER.info("handling AssignDb2ToGovHydroREvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroR entity = assignDb2(event.getGovHydroRId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroR(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroR(entity);
  }

  /*
   * @param	event UnAssignDb2FromGovHydroREvent
   */
  @EventHandler(payloadType = UnAssignDb2FromGovHydroREvent.class)
  public void handle(UnAssignDb2FromGovHydroREvent event) {
    LOGGER.info("handling UnAssignDb2FromGovHydroREvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroR entity = unAssignDb2(event.getGovHydroRId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroR(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroR(entity);
  }

  /*
   * @param	event AssignDturbToGovHydroREvent
   */
  @EventHandler(payloadType = AssignDturbToGovHydroREvent.class)
  public void handle(AssignDturbToGovHydroREvent event) {
    LOGGER.info("handling AssignDturbToGovHydroREvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroR entity = assignDturb(event.getGovHydroRId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroR(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroR(entity);
  }

  /*
   * @param	event UnAssignDturbFromGovHydroREvent
   */
  @EventHandler(payloadType = UnAssignDturbFromGovHydroREvent.class)
  public void handle(UnAssignDturbFromGovHydroREvent event) {
    LOGGER.info("handling UnAssignDturbFromGovHydroREvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroR entity = unAssignDturb(event.getGovHydroRId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroR(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroR(entity);
  }

  /*
   * @param	event AssignEpsToGovHydroREvent
   */
  @EventHandler(payloadType = AssignEpsToGovHydroREvent.class)
  public void handle(AssignEpsToGovHydroREvent event) {
    LOGGER.info("handling AssignEpsToGovHydroREvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroR entity = assignEps(event.getGovHydroRId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroR(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroR(entity);
  }

  /*
   * @param	event UnAssignEpsFromGovHydroREvent
   */
  @EventHandler(payloadType = UnAssignEpsFromGovHydroREvent.class)
  public void handle(UnAssignEpsFromGovHydroREvent event) {
    LOGGER.info("handling UnAssignEpsFromGovHydroREvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroR entity = unAssignEps(event.getGovHydroRId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroR(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroR(entity);
  }

  /*
   * @param	event AssignGmaxToGovHydroREvent
   */
  @EventHandler(payloadType = AssignGmaxToGovHydroREvent.class)
  public void handle(AssignGmaxToGovHydroREvent event) {
    LOGGER.info("handling AssignGmaxToGovHydroREvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroR entity = assignGmax(event.getGovHydroRId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroR(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroR(entity);
  }

  /*
   * @param	event UnAssignGmaxFromGovHydroREvent
   */
  @EventHandler(payloadType = UnAssignGmaxFromGovHydroREvent.class)
  public void handle(UnAssignGmaxFromGovHydroREvent event) {
    LOGGER.info("handling UnAssignGmaxFromGovHydroREvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroR entity = unAssignGmax(event.getGovHydroRId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroR(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroR(entity);
  }

  /*
   * @param	event AssignGminToGovHydroREvent
   */
  @EventHandler(payloadType = AssignGminToGovHydroREvent.class)
  public void handle(AssignGminToGovHydroREvent event) {
    LOGGER.info("handling AssignGminToGovHydroREvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroR entity = assignGmin(event.getGovHydroRId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroR(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroR(entity);
  }

  /*
   * @param	event UnAssignGminFromGovHydroREvent
   */
  @EventHandler(payloadType = UnAssignGminFromGovHydroREvent.class)
  public void handle(UnAssignGminFromGovHydroREvent event) {
    LOGGER.info("handling UnAssignGminFromGovHydroREvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroR entity = unAssignGmin(event.getGovHydroRId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroR(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroR(entity);
  }

  /*
   * @param	event AssignGv1ToGovHydroREvent
   */
  @EventHandler(payloadType = AssignGv1ToGovHydroREvent.class)
  public void handle(AssignGv1ToGovHydroREvent event) {
    LOGGER.info("handling AssignGv1ToGovHydroREvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroR entity = assignGv1(event.getGovHydroRId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroR(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroR(entity);
  }

  /*
   * @param	event UnAssignGv1FromGovHydroREvent
   */
  @EventHandler(payloadType = UnAssignGv1FromGovHydroREvent.class)
  public void handle(UnAssignGv1FromGovHydroREvent event) {
    LOGGER.info("handling UnAssignGv1FromGovHydroREvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroR entity = unAssignGv1(event.getGovHydroRId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroR(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroR(entity);
  }

  /*
   * @param	event AssignGv2ToGovHydroREvent
   */
  @EventHandler(payloadType = AssignGv2ToGovHydroREvent.class)
  public void handle(AssignGv2ToGovHydroREvent event) {
    LOGGER.info("handling AssignGv2ToGovHydroREvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroR entity = assignGv2(event.getGovHydroRId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroR(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroR(entity);
  }

  /*
   * @param	event UnAssignGv2FromGovHydroREvent
   */
  @EventHandler(payloadType = UnAssignGv2FromGovHydroREvent.class)
  public void handle(UnAssignGv2FromGovHydroREvent event) {
    LOGGER.info("handling UnAssignGv2FromGovHydroREvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroR entity = unAssignGv2(event.getGovHydroRId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroR(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroR(entity);
  }

  /*
   * @param	event AssignGv3ToGovHydroREvent
   */
  @EventHandler(payloadType = AssignGv3ToGovHydroREvent.class)
  public void handle(AssignGv3ToGovHydroREvent event) {
    LOGGER.info("handling AssignGv3ToGovHydroREvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroR entity = assignGv3(event.getGovHydroRId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroR(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroR(entity);
  }

  /*
   * @param	event UnAssignGv3FromGovHydroREvent
   */
  @EventHandler(payloadType = UnAssignGv3FromGovHydroREvent.class)
  public void handle(UnAssignGv3FromGovHydroREvent event) {
    LOGGER.info("handling UnAssignGv3FromGovHydroREvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroR entity = unAssignGv3(event.getGovHydroRId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroR(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroR(entity);
  }

  /*
   * @param	event AssignGv4ToGovHydroREvent
   */
  @EventHandler(payloadType = AssignGv4ToGovHydroREvent.class)
  public void handle(AssignGv4ToGovHydroREvent event) {
    LOGGER.info("handling AssignGv4ToGovHydroREvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroR entity = assignGv4(event.getGovHydroRId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroR(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroR(entity);
  }

  /*
   * @param	event UnAssignGv4FromGovHydroREvent
   */
  @EventHandler(payloadType = UnAssignGv4FromGovHydroREvent.class)
  public void handle(UnAssignGv4FromGovHydroREvent event) {
    LOGGER.info("handling UnAssignGv4FromGovHydroREvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroR entity = unAssignGv4(event.getGovHydroRId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroR(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroR(entity);
  }

  /*
   * @param	event AssignGv5ToGovHydroREvent
   */
  @EventHandler(payloadType = AssignGv5ToGovHydroREvent.class)
  public void handle(AssignGv5ToGovHydroREvent event) {
    LOGGER.info("handling AssignGv5ToGovHydroREvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroR entity = assignGv5(event.getGovHydroRId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroR(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroR(entity);
  }

  /*
   * @param	event UnAssignGv5FromGovHydroREvent
   */
  @EventHandler(payloadType = UnAssignGv5FromGovHydroREvent.class)
  public void handle(UnAssignGv5FromGovHydroREvent event) {
    LOGGER.info("handling UnAssignGv5FromGovHydroREvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroR entity = unAssignGv5(event.getGovHydroRId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroR(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroR(entity);
  }

  /*
   * @param	event AssignGv6ToGovHydroREvent
   */
  @EventHandler(payloadType = AssignGv6ToGovHydroREvent.class)
  public void handle(AssignGv6ToGovHydroREvent event) {
    LOGGER.info("handling AssignGv6ToGovHydroREvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroR entity = assignGv6(event.getGovHydroRId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroR(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroR(entity);
  }

  /*
   * @param	event UnAssignGv6FromGovHydroREvent
   */
  @EventHandler(payloadType = UnAssignGv6FromGovHydroREvent.class)
  public void handle(UnAssignGv6FromGovHydroREvent event) {
    LOGGER.info("handling UnAssignGv6FromGovHydroREvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroR entity = unAssignGv6(event.getGovHydroRId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroR(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroR(entity);
  }

  /*
   * @param	event AssignH0ToGovHydroREvent
   */
  @EventHandler(payloadType = AssignH0ToGovHydroREvent.class)
  public void handle(AssignH0ToGovHydroREvent event) {
    LOGGER.info("handling AssignH0ToGovHydroREvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroR entity = assignH0(event.getGovHydroRId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroR(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroR(entity);
  }

  /*
   * @param	event UnAssignH0FromGovHydroREvent
   */
  @EventHandler(payloadType = UnAssignH0FromGovHydroREvent.class)
  public void handle(UnAssignH0FromGovHydroREvent event) {
    LOGGER.info("handling UnAssignH0FromGovHydroREvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroR entity = unAssignH0(event.getGovHydroRId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroR(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroR(entity);
  }

  /*
   * @param	event AssignInputSignalToGovHydroREvent
   */
  @EventHandler(payloadType = AssignInputSignalToGovHydroREvent.class)
  public void handle(AssignInputSignalToGovHydroREvent event) {
    LOGGER.info("handling AssignInputSignalToGovHydroREvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroR entity = assignInputSignal(event.getGovHydroRId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroR(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroR(entity);
  }

  /*
   * @param	event UnAssignInputSignalFromGovHydroREvent
   */
  @EventHandler(payloadType = UnAssignInputSignalFromGovHydroREvent.class)
  public void handle(UnAssignInputSignalFromGovHydroREvent event) {
    LOGGER.info("handling UnAssignInputSignalFromGovHydroREvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroR entity = unAssignInputSignal(event.getGovHydroRId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroR(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroR(entity);
  }

  /*
   * @param	event AssignKgToGovHydroREvent
   */
  @EventHandler(payloadType = AssignKgToGovHydroREvent.class)
  public void handle(AssignKgToGovHydroREvent event) {
    LOGGER.info("handling AssignKgToGovHydroREvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroR entity = assignKg(event.getGovHydroRId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroR(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroR(entity);
  }

  /*
   * @param	event UnAssignKgFromGovHydroREvent
   */
  @EventHandler(payloadType = UnAssignKgFromGovHydroREvent.class)
  public void handle(UnAssignKgFromGovHydroREvent event) {
    LOGGER.info("handling UnAssignKgFromGovHydroREvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroR entity = unAssignKg(event.getGovHydroRId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroR(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroR(entity);
  }

  /*
   * @param	event AssignKiToGovHydroREvent
   */
  @EventHandler(payloadType = AssignKiToGovHydroREvent.class)
  public void handle(AssignKiToGovHydroREvent event) {
    LOGGER.info("handling AssignKiToGovHydroREvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroR entity = assignKi(event.getGovHydroRId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroR(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroR(entity);
  }

  /*
   * @param	event UnAssignKiFromGovHydroREvent
   */
  @EventHandler(payloadType = UnAssignKiFromGovHydroREvent.class)
  public void handle(UnAssignKiFromGovHydroREvent event) {
    LOGGER.info("handling UnAssignKiFromGovHydroREvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroR entity = unAssignKi(event.getGovHydroRId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroR(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroR(entity);
  }

  /*
   * @param	event AssignMwbaseToGovHydroREvent
   */
  @EventHandler(payloadType = AssignMwbaseToGovHydroREvent.class)
  public void handle(AssignMwbaseToGovHydroREvent event) {
    LOGGER.info("handling AssignMwbaseToGovHydroREvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroR entity = assignMwbase(event.getGovHydroRId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroR(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroR(entity);
  }

  /*
   * @param	event UnAssignMwbaseFromGovHydroREvent
   */
  @EventHandler(payloadType = UnAssignMwbaseFromGovHydroREvent.class)
  public void handle(UnAssignMwbaseFromGovHydroREvent event) {
    LOGGER.info("handling UnAssignMwbaseFromGovHydroREvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroR entity = unAssignMwbase(event.getGovHydroRId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroR(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroR(entity);
  }

  /*
   * @param	event AssignPgv1ToGovHydroREvent
   */
  @EventHandler(payloadType = AssignPgv1ToGovHydroREvent.class)
  public void handle(AssignPgv1ToGovHydroREvent event) {
    LOGGER.info("handling AssignPgv1ToGovHydroREvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroR entity = assignPgv1(event.getGovHydroRId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroR(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroR(entity);
  }

  /*
   * @param	event UnAssignPgv1FromGovHydroREvent
   */
  @EventHandler(payloadType = UnAssignPgv1FromGovHydroREvent.class)
  public void handle(UnAssignPgv1FromGovHydroREvent event) {
    LOGGER.info("handling UnAssignPgv1FromGovHydroREvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroR entity = unAssignPgv1(event.getGovHydroRId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroR(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroR(entity);
  }

  /*
   * @param	event AssignPgv2ToGovHydroREvent
   */
  @EventHandler(payloadType = AssignPgv2ToGovHydroREvent.class)
  public void handle(AssignPgv2ToGovHydroREvent event) {
    LOGGER.info("handling AssignPgv2ToGovHydroREvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroR entity = assignPgv2(event.getGovHydroRId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroR(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroR(entity);
  }

  /*
   * @param	event UnAssignPgv2FromGovHydroREvent
   */
  @EventHandler(payloadType = UnAssignPgv2FromGovHydroREvent.class)
  public void handle(UnAssignPgv2FromGovHydroREvent event) {
    LOGGER.info("handling UnAssignPgv2FromGovHydroREvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroR entity = unAssignPgv2(event.getGovHydroRId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroR(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroR(entity);
  }

  /*
   * @param	event AssignPgv3ToGovHydroREvent
   */
  @EventHandler(payloadType = AssignPgv3ToGovHydroREvent.class)
  public void handle(AssignPgv3ToGovHydroREvent event) {
    LOGGER.info("handling AssignPgv3ToGovHydroREvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroR entity = assignPgv3(event.getGovHydroRId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroR(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroR(entity);
  }

  /*
   * @param	event UnAssignPgv3FromGovHydroREvent
   */
  @EventHandler(payloadType = UnAssignPgv3FromGovHydroREvent.class)
  public void handle(UnAssignPgv3FromGovHydroREvent event) {
    LOGGER.info("handling UnAssignPgv3FromGovHydroREvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroR entity = unAssignPgv3(event.getGovHydroRId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroR(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroR(entity);
  }

  /*
   * @param	event AssignPgv4ToGovHydroREvent
   */
  @EventHandler(payloadType = AssignPgv4ToGovHydroREvent.class)
  public void handle(AssignPgv4ToGovHydroREvent event) {
    LOGGER.info("handling AssignPgv4ToGovHydroREvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroR entity = assignPgv4(event.getGovHydroRId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroR(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroR(entity);
  }

  /*
   * @param	event UnAssignPgv4FromGovHydroREvent
   */
  @EventHandler(payloadType = UnAssignPgv4FromGovHydroREvent.class)
  public void handle(UnAssignPgv4FromGovHydroREvent event) {
    LOGGER.info("handling UnAssignPgv4FromGovHydroREvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroR entity = unAssignPgv4(event.getGovHydroRId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroR(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroR(entity);
  }

  /*
   * @param	event AssignPgv5ToGovHydroREvent
   */
  @EventHandler(payloadType = AssignPgv5ToGovHydroREvent.class)
  public void handle(AssignPgv5ToGovHydroREvent event) {
    LOGGER.info("handling AssignPgv5ToGovHydroREvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroR entity = assignPgv5(event.getGovHydroRId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroR(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroR(entity);
  }

  /*
   * @param	event UnAssignPgv5FromGovHydroREvent
   */
  @EventHandler(payloadType = UnAssignPgv5FromGovHydroREvent.class)
  public void handle(UnAssignPgv5FromGovHydroREvent event) {
    LOGGER.info("handling UnAssignPgv5FromGovHydroREvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroR entity = unAssignPgv5(event.getGovHydroRId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroR(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroR(entity);
  }

  /*
   * @param	event AssignPgv6ToGovHydroREvent
   */
  @EventHandler(payloadType = AssignPgv6ToGovHydroREvent.class)
  public void handle(AssignPgv6ToGovHydroREvent event) {
    LOGGER.info("handling AssignPgv6ToGovHydroREvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroR entity = assignPgv6(event.getGovHydroRId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroR(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroR(entity);
  }

  /*
   * @param	event UnAssignPgv6FromGovHydroREvent
   */
  @EventHandler(payloadType = UnAssignPgv6FromGovHydroREvent.class)
  public void handle(UnAssignPgv6FromGovHydroREvent event) {
    LOGGER.info("handling UnAssignPgv6FromGovHydroREvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroR entity = unAssignPgv6(event.getGovHydroRId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroR(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroR(entity);
  }

  /*
   * @param	event AssignPmaxToGovHydroREvent
   */
  @EventHandler(payloadType = AssignPmaxToGovHydroREvent.class)
  public void handle(AssignPmaxToGovHydroREvent event) {
    LOGGER.info("handling AssignPmaxToGovHydroREvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroR entity = assignPmax(event.getGovHydroRId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroR(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroR(entity);
  }

  /*
   * @param	event UnAssignPmaxFromGovHydroREvent
   */
  @EventHandler(payloadType = UnAssignPmaxFromGovHydroREvent.class)
  public void handle(UnAssignPmaxFromGovHydroREvent event) {
    LOGGER.info("handling UnAssignPmaxFromGovHydroREvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroR entity = unAssignPmax(event.getGovHydroRId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroR(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroR(entity);
  }

  /*
   * @param	event AssignPminToGovHydroREvent
   */
  @EventHandler(payloadType = AssignPminToGovHydroREvent.class)
  public void handle(AssignPminToGovHydroREvent event) {
    LOGGER.info("handling AssignPminToGovHydroREvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroR entity = assignPmin(event.getGovHydroRId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroR(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroR(entity);
  }

  /*
   * @param	event UnAssignPminFromGovHydroREvent
   */
  @EventHandler(payloadType = UnAssignPminFromGovHydroREvent.class)
  public void handle(UnAssignPminFromGovHydroREvent event) {
    LOGGER.info("handling UnAssignPminFromGovHydroREvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroR entity = unAssignPmin(event.getGovHydroRId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroR(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroR(entity);
  }

  /*
   * @param	event AssignQnlToGovHydroREvent
   */
  @EventHandler(payloadType = AssignQnlToGovHydroREvent.class)
  public void handle(AssignQnlToGovHydroREvent event) {
    LOGGER.info("handling AssignQnlToGovHydroREvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroR entity = assignQnl(event.getGovHydroRId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroR(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroR(entity);
  }

  /*
   * @param	event UnAssignQnlFromGovHydroREvent
   */
  @EventHandler(payloadType = UnAssignQnlFromGovHydroREvent.class)
  public void handle(UnAssignQnlFromGovHydroREvent event) {
    LOGGER.info("handling UnAssignQnlFromGovHydroREvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroR entity = unAssignQnl(event.getGovHydroRId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroR(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroR(entity);
  }

  /*
   * @param	event AssignRToGovHydroREvent
   */
  @EventHandler(payloadType = AssignRToGovHydroREvent.class)
  public void handle(AssignRToGovHydroREvent event) {
    LOGGER.info("handling AssignRToGovHydroREvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroR entity = assignR(event.getGovHydroRId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroR(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroR(entity);
  }

  /*
   * @param	event UnAssignRFromGovHydroREvent
   */
  @EventHandler(payloadType = UnAssignRFromGovHydroREvent.class)
  public void handle(UnAssignRFromGovHydroREvent event) {
    LOGGER.info("handling UnAssignRFromGovHydroREvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroR entity = unAssignR(event.getGovHydroRId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroR(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroR(entity);
  }

  /*
   * @param	event AssignT1ToGovHydroREvent
   */
  @EventHandler(payloadType = AssignT1ToGovHydroREvent.class)
  public void handle(AssignT1ToGovHydroREvent event) {
    LOGGER.info("handling AssignT1ToGovHydroREvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroR entity = assignT1(event.getGovHydroRId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroR(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroR(entity);
  }

  /*
   * @param	event UnAssignT1FromGovHydroREvent
   */
  @EventHandler(payloadType = UnAssignT1FromGovHydroREvent.class)
  public void handle(UnAssignT1FromGovHydroREvent event) {
    LOGGER.info("handling UnAssignT1FromGovHydroREvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroR entity = unAssignT1(event.getGovHydroRId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroR(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroR(entity);
  }

  /*
   * @param	event AssignT2ToGovHydroREvent
   */
  @EventHandler(payloadType = AssignT2ToGovHydroREvent.class)
  public void handle(AssignT2ToGovHydroREvent event) {
    LOGGER.info("handling AssignT2ToGovHydroREvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroR entity = assignT2(event.getGovHydroRId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroR(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroR(entity);
  }

  /*
   * @param	event UnAssignT2FromGovHydroREvent
   */
  @EventHandler(payloadType = UnAssignT2FromGovHydroREvent.class)
  public void handle(UnAssignT2FromGovHydroREvent event) {
    LOGGER.info("handling UnAssignT2FromGovHydroREvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroR entity = unAssignT2(event.getGovHydroRId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroR(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroR(entity);
  }

  /*
   * @param	event AssignT3ToGovHydroREvent
   */
  @EventHandler(payloadType = AssignT3ToGovHydroREvent.class)
  public void handle(AssignT3ToGovHydroREvent event) {
    LOGGER.info("handling AssignT3ToGovHydroREvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroR entity = assignT3(event.getGovHydroRId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroR(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroR(entity);
  }

  /*
   * @param	event UnAssignT3FromGovHydroREvent
   */
  @EventHandler(payloadType = UnAssignT3FromGovHydroREvent.class)
  public void handle(UnAssignT3FromGovHydroREvent event) {
    LOGGER.info("handling UnAssignT3FromGovHydroREvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroR entity = unAssignT3(event.getGovHydroRId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroR(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroR(entity);
  }

  /*
   * @param	event AssignT4ToGovHydroREvent
   */
  @EventHandler(payloadType = AssignT4ToGovHydroREvent.class)
  public void handle(AssignT4ToGovHydroREvent event) {
    LOGGER.info("handling AssignT4ToGovHydroREvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroR entity = assignT4(event.getGovHydroRId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroR(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroR(entity);
  }

  /*
   * @param	event UnAssignT4FromGovHydroREvent
   */
  @EventHandler(payloadType = UnAssignT4FromGovHydroREvent.class)
  public void handle(UnAssignT4FromGovHydroREvent event) {
    LOGGER.info("handling UnAssignT4FromGovHydroREvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroR entity = unAssignT4(event.getGovHydroRId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroR(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroR(entity);
  }

  /*
   * @param	event AssignT5ToGovHydroREvent
   */
  @EventHandler(payloadType = AssignT5ToGovHydroREvent.class)
  public void handle(AssignT5ToGovHydroREvent event) {
    LOGGER.info("handling AssignT5ToGovHydroREvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroR entity = assignT5(event.getGovHydroRId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroR(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroR(entity);
  }

  /*
   * @param	event UnAssignT5FromGovHydroREvent
   */
  @EventHandler(payloadType = UnAssignT5FromGovHydroREvent.class)
  public void handle(UnAssignT5FromGovHydroREvent event) {
    LOGGER.info("handling UnAssignT5FromGovHydroREvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroR entity = unAssignT5(event.getGovHydroRId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroR(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroR(entity);
  }

  /*
   * @param	event AssignT6ToGovHydroREvent
   */
  @EventHandler(payloadType = AssignT6ToGovHydroREvent.class)
  public void handle(AssignT6ToGovHydroREvent event) {
    LOGGER.info("handling AssignT6ToGovHydroREvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroR entity = assignT6(event.getGovHydroRId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroR(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroR(entity);
  }

  /*
   * @param	event UnAssignT6FromGovHydroREvent
   */
  @EventHandler(payloadType = UnAssignT6FromGovHydroREvent.class)
  public void handle(UnAssignT6FromGovHydroREvent event) {
    LOGGER.info("handling UnAssignT6FromGovHydroREvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroR entity = unAssignT6(event.getGovHydroRId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroR(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroR(entity);
  }

  /*
   * @param	event AssignT7ToGovHydroREvent
   */
  @EventHandler(payloadType = AssignT7ToGovHydroREvent.class)
  public void handle(AssignT7ToGovHydroREvent event) {
    LOGGER.info("handling AssignT7ToGovHydroREvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroR entity = assignT7(event.getGovHydroRId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroR(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroR(entity);
  }

  /*
   * @param	event UnAssignT7FromGovHydroREvent
   */
  @EventHandler(payloadType = UnAssignT7FromGovHydroREvent.class)
  public void handle(UnAssignT7FromGovHydroREvent event) {
    LOGGER.info("handling UnAssignT7FromGovHydroREvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroR entity = unAssignT7(event.getGovHydroRId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroR(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroR(entity);
  }

  /*
   * @param	event AssignT8ToGovHydroREvent
   */
  @EventHandler(payloadType = AssignT8ToGovHydroREvent.class)
  public void handle(AssignT8ToGovHydroREvent event) {
    LOGGER.info("handling AssignT8ToGovHydroREvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroR entity = assignT8(event.getGovHydroRId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroR(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroR(entity);
  }

  /*
   * @param	event UnAssignT8FromGovHydroREvent
   */
  @EventHandler(payloadType = UnAssignT8FromGovHydroREvent.class)
  public void handle(UnAssignT8FromGovHydroREvent event) {
    LOGGER.info("handling UnAssignT8FromGovHydroREvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroR entity = unAssignT8(event.getGovHydroRId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroR(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroR(entity);
  }

  /*
   * @param	event AssignTdToGovHydroREvent
   */
  @EventHandler(payloadType = AssignTdToGovHydroREvent.class)
  public void handle(AssignTdToGovHydroREvent event) {
    LOGGER.info("handling AssignTdToGovHydroREvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroR entity = assignTd(event.getGovHydroRId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroR(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroR(entity);
  }

  /*
   * @param	event UnAssignTdFromGovHydroREvent
   */
  @EventHandler(payloadType = UnAssignTdFromGovHydroREvent.class)
  public void handle(UnAssignTdFromGovHydroREvent event) {
    LOGGER.info("handling UnAssignTdFromGovHydroREvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroR entity = unAssignTd(event.getGovHydroRId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroR(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroR(entity);
  }

  /*
   * @param	event AssignTpToGovHydroREvent
   */
  @EventHandler(payloadType = AssignTpToGovHydroREvent.class)
  public void handle(AssignTpToGovHydroREvent event) {
    LOGGER.info("handling AssignTpToGovHydroREvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroR entity = assignTp(event.getGovHydroRId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroR(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroR(entity);
  }

  /*
   * @param	event UnAssignTpFromGovHydroREvent
   */
  @EventHandler(payloadType = UnAssignTpFromGovHydroREvent.class)
  public void handle(UnAssignTpFromGovHydroREvent event) {
    LOGGER.info("handling UnAssignTpFromGovHydroREvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroR entity = unAssignTp(event.getGovHydroRId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroR(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroR(entity);
  }

  /*
   * @param	event AssignTtToGovHydroREvent
   */
  @EventHandler(payloadType = AssignTtToGovHydroREvent.class)
  public void handle(AssignTtToGovHydroREvent event) {
    LOGGER.info("handling AssignTtToGovHydroREvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroR entity = assignTt(event.getGovHydroRId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroR(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroR(entity);
  }

  /*
   * @param	event UnAssignTtFromGovHydroREvent
   */
  @EventHandler(payloadType = UnAssignTtFromGovHydroREvent.class)
  public void handle(UnAssignTtFromGovHydroREvent event) {
    LOGGER.info("handling UnAssignTtFromGovHydroREvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroR entity = unAssignTt(event.getGovHydroRId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroR(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroR(entity);
  }

  /*
   * @param	event AssignTwToGovHydroREvent
   */
  @EventHandler(payloadType = AssignTwToGovHydroREvent.class)
  public void handle(AssignTwToGovHydroREvent event) {
    LOGGER.info("handling AssignTwToGovHydroREvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroR entity = assignTw(event.getGovHydroRId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroR(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroR(entity);
  }

  /*
   * @param	event UnAssignTwFromGovHydroREvent
   */
  @EventHandler(payloadType = UnAssignTwFromGovHydroREvent.class)
  public void handle(UnAssignTwFromGovHydroREvent event) {
    LOGGER.info("handling UnAssignTwFromGovHydroREvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroR entity = unAssignTw(event.getGovHydroRId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroR(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroR(entity);
  }

  /*
   * @param	event AssignVelclToGovHydroREvent
   */
  @EventHandler(payloadType = AssignVelclToGovHydroREvent.class)
  public void handle(AssignVelclToGovHydroREvent event) {
    LOGGER.info("handling AssignVelclToGovHydroREvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroR entity = assignVelcl(event.getGovHydroRId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroR(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroR(entity);
  }

  /*
   * @param	event UnAssignVelclFromGovHydroREvent
   */
  @EventHandler(payloadType = UnAssignVelclFromGovHydroREvent.class)
  public void handle(UnAssignVelclFromGovHydroREvent event) {
    LOGGER.info("handling UnAssignVelclFromGovHydroREvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroR entity = unAssignVelcl(event.getGovHydroRId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroR(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroR(entity);
  }

  /*
   * @param	event AssignVelopToGovHydroREvent
   */
  @EventHandler(payloadType = AssignVelopToGovHydroREvent.class)
  public void handle(AssignVelopToGovHydroREvent event) {
    LOGGER.info("handling AssignVelopToGovHydroREvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroR entity = assignVelop(event.getGovHydroRId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroR(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroR(entity);
  }

  /*
   * @param	event UnAssignVelopFromGovHydroREvent
   */
  @EventHandler(payloadType = UnAssignVelopFromGovHydroREvent.class)
  public void handle(UnAssignVelopFromGovHydroREvent event) {
    LOGGER.info("handling UnAssignVelopFromGovHydroREvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroR entity = unAssignVelop(event.getGovHydroRId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroR(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroR(entity);
  }

  /**
   * Method to retrieve the GovHydroR via an GovHydroRPrimaryKey.
   *
   * @param id Long
   * @return GovHydroR
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public GovHydroR handle(FindGovHydroRQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getGovHydroRId());
  }

  /**
   * Method to retrieve a collection of all GovHydroRs
   *
   * @param query FindAllGovHydroRQuery
   * @return List<GovHydroR>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<GovHydroR> handle(FindAllGovHydroRQuery query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindGovHydroR, but only if the id matches
   *
   * @param entity GovHydroR
   */
  protected void emitFindGovHydroR(GovHydroR entity) {
    LOGGER.info("handling emitFindGovHydroR");

    queryUpdateEmitter.emit(
        FindGovHydroRQuery.class,
        query -> query.getFilter().getGovHydroRId().equals(entity.getGovHydroRId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllGovHydroR
   *
   * @param entity GovHydroR
   */
  protected void emitFindAllGovHydroR(GovHydroR entity) {
    LOGGER.info("handling emitFindAllGovHydroR");

    queryUpdateEmitter.emit(FindAllGovHydroRQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(GovHydroRProjector.class.getName());
}
