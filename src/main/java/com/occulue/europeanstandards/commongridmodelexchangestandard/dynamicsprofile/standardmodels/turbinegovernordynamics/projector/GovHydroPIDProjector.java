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
 * Projector for GovHydroPID as outlined for the CQRS pattern. All event handling and query handling
 * related to GovHydroPID are invoked here and dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by GovHydroPIDAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("govHydroPID")
@Component("govHydroPID-projector")
public class GovHydroPIDProjector extends GovHydroPIDEntityProjector {

  // core constructor
  public GovHydroPIDProjector(
      GovHydroPIDRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateGovHydroPIDEvent
   */
  @EventHandler(payloadType = CreateGovHydroPIDEvent.class)
  public void handle(CreateGovHydroPIDEvent event) {
    LOGGER.info("handling CreateGovHydroPIDEvent - " + event);
    GovHydroPID entity = new GovHydroPID();
    entity.setGovHydroPIDId(event.getGovHydroPIDId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPID(entity);
  }

  /*
   * @param	event UpdateGovHydroPIDEvent
   */
  @EventHandler(payloadType = UpdateGovHydroPIDEvent.class)
  public void handle(UpdateGovHydroPIDEvent event) {
    LOGGER.info("handling UpdateGovHydroPIDEvent - " + event);

    GovHydroPID entity = new GovHydroPID();
    entity.setGovHydroPIDId(event.getGovHydroPIDId());
    entity.setAturb(event.getAturb());
    entity.setBturb(event.getBturb());
    entity.setDb1(event.getDb1());
    entity.setDb2(event.getDb2());
    entity.setEps(event.getEps());
    entity.setGv1(event.getGv1());
    entity.setGv2(event.getGv2());
    entity.setGv3(event.getGv3());
    entity.setGv4(event.getGv4());
    entity.setGv5(event.getGv5());
    entity.setGv6(event.getGv6());
    entity.setInputSignal(event.getInputSignal());
    entity.setKd(event.getKd());
    entity.setKg(event.getKg());
    entity.setKi(event.getKi());
    entity.setKp(event.getKp());
    entity.setMwbase(event.getMwbase());
    entity.setPgv1(event.getPgv1());
    entity.setPgv2(event.getPgv2());
    entity.setPgv3(event.getPgv3());
    entity.setPgv4(event.getPgv4());
    entity.setPgv5(event.getPgv5());
    entity.setPgv6(event.getPgv6());
    entity.setPmax(event.getPmax());
    entity.setPmin(event.getPmin());
    entity.setR(event.getR());
    entity.setTd(event.getTd());
    entity.setTf(event.getTf());
    entity.setTp(event.getTp());
    entity.setTt(event.getTt());
    entity.setTturb(event.getTturb());
    entity.setVelcl(event.getVelcl());
    entity.setVelop(event.getVelop());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPID(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPID(entity);
  }

  /*
   * @param	event DeleteGovHydroPIDEvent
   */
  @EventHandler(payloadType = DeleteGovHydroPIDEvent.class)
  public void handle(DeleteGovHydroPIDEvent event) {
    LOGGER.info("handling DeleteGovHydroPIDEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    GovHydroPID entity = delete(event.getGovHydroPIDId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPID(entity);
  }

  /*
   * @param	event AssignAturbToGovHydroPIDEvent
   */
  @EventHandler(payloadType = AssignAturbToGovHydroPIDEvent.class)
  public void handle(AssignAturbToGovHydroPIDEvent event) {
    LOGGER.info("handling AssignAturbToGovHydroPIDEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroPID entity = assignAturb(event.getGovHydroPIDId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPID(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPID(entity);
  }

  /*
   * @param	event UnAssignAturbFromGovHydroPIDEvent
   */
  @EventHandler(payloadType = UnAssignAturbFromGovHydroPIDEvent.class)
  public void handle(UnAssignAturbFromGovHydroPIDEvent event) {
    LOGGER.info("handling UnAssignAturbFromGovHydroPIDEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroPID entity = unAssignAturb(event.getGovHydroPIDId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPID(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPID(entity);
  }

  /*
   * @param	event AssignBturbToGovHydroPIDEvent
   */
  @EventHandler(payloadType = AssignBturbToGovHydroPIDEvent.class)
  public void handle(AssignBturbToGovHydroPIDEvent event) {
    LOGGER.info("handling AssignBturbToGovHydroPIDEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroPID entity = assignBturb(event.getGovHydroPIDId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPID(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPID(entity);
  }

  /*
   * @param	event UnAssignBturbFromGovHydroPIDEvent
   */
  @EventHandler(payloadType = UnAssignBturbFromGovHydroPIDEvent.class)
  public void handle(UnAssignBturbFromGovHydroPIDEvent event) {
    LOGGER.info("handling UnAssignBturbFromGovHydroPIDEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroPID entity = unAssignBturb(event.getGovHydroPIDId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPID(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPID(entity);
  }

  /*
   * @param	event AssignDb1ToGovHydroPIDEvent
   */
  @EventHandler(payloadType = AssignDb1ToGovHydroPIDEvent.class)
  public void handle(AssignDb1ToGovHydroPIDEvent event) {
    LOGGER.info("handling AssignDb1ToGovHydroPIDEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroPID entity = assignDb1(event.getGovHydroPIDId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPID(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPID(entity);
  }

  /*
   * @param	event UnAssignDb1FromGovHydroPIDEvent
   */
  @EventHandler(payloadType = UnAssignDb1FromGovHydroPIDEvent.class)
  public void handle(UnAssignDb1FromGovHydroPIDEvent event) {
    LOGGER.info("handling UnAssignDb1FromGovHydroPIDEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroPID entity = unAssignDb1(event.getGovHydroPIDId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPID(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPID(entity);
  }

  /*
   * @param	event AssignDb2ToGovHydroPIDEvent
   */
  @EventHandler(payloadType = AssignDb2ToGovHydroPIDEvent.class)
  public void handle(AssignDb2ToGovHydroPIDEvent event) {
    LOGGER.info("handling AssignDb2ToGovHydroPIDEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroPID entity = assignDb2(event.getGovHydroPIDId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPID(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPID(entity);
  }

  /*
   * @param	event UnAssignDb2FromGovHydroPIDEvent
   */
  @EventHandler(payloadType = UnAssignDb2FromGovHydroPIDEvent.class)
  public void handle(UnAssignDb2FromGovHydroPIDEvent event) {
    LOGGER.info("handling UnAssignDb2FromGovHydroPIDEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroPID entity = unAssignDb2(event.getGovHydroPIDId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPID(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPID(entity);
  }

  /*
   * @param	event AssignEpsToGovHydroPIDEvent
   */
  @EventHandler(payloadType = AssignEpsToGovHydroPIDEvent.class)
  public void handle(AssignEpsToGovHydroPIDEvent event) {
    LOGGER.info("handling AssignEpsToGovHydroPIDEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroPID entity = assignEps(event.getGovHydroPIDId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPID(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPID(entity);
  }

  /*
   * @param	event UnAssignEpsFromGovHydroPIDEvent
   */
  @EventHandler(payloadType = UnAssignEpsFromGovHydroPIDEvent.class)
  public void handle(UnAssignEpsFromGovHydroPIDEvent event) {
    LOGGER.info("handling UnAssignEpsFromGovHydroPIDEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroPID entity = unAssignEps(event.getGovHydroPIDId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPID(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPID(entity);
  }

  /*
   * @param	event AssignGv1ToGovHydroPIDEvent
   */
  @EventHandler(payloadType = AssignGv1ToGovHydroPIDEvent.class)
  public void handle(AssignGv1ToGovHydroPIDEvent event) {
    LOGGER.info("handling AssignGv1ToGovHydroPIDEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroPID entity = assignGv1(event.getGovHydroPIDId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPID(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPID(entity);
  }

  /*
   * @param	event UnAssignGv1FromGovHydroPIDEvent
   */
  @EventHandler(payloadType = UnAssignGv1FromGovHydroPIDEvent.class)
  public void handle(UnAssignGv1FromGovHydroPIDEvent event) {
    LOGGER.info("handling UnAssignGv1FromGovHydroPIDEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroPID entity = unAssignGv1(event.getGovHydroPIDId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPID(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPID(entity);
  }

  /*
   * @param	event AssignGv2ToGovHydroPIDEvent
   */
  @EventHandler(payloadType = AssignGv2ToGovHydroPIDEvent.class)
  public void handle(AssignGv2ToGovHydroPIDEvent event) {
    LOGGER.info("handling AssignGv2ToGovHydroPIDEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroPID entity = assignGv2(event.getGovHydroPIDId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPID(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPID(entity);
  }

  /*
   * @param	event UnAssignGv2FromGovHydroPIDEvent
   */
  @EventHandler(payloadType = UnAssignGv2FromGovHydroPIDEvent.class)
  public void handle(UnAssignGv2FromGovHydroPIDEvent event) {
    LOGGER.info("handling UnAssignGv2FromGovHydroPIDEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroPID entity = unAssignGv2(event.getGovHydroPIDId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPID(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPID(entity);
  }

  /*
   * @param	event AssignGv3ToGovHydroPIDEvent
   */
  @EventHandler(payloadType = AssignGv3ToGovHydroPIDEvent.class)
  public void handle(AssignGv3ToGovHydroPIDEvent event) {
    LOGGER.info("handling AssignGv3ToGovHydroPIDEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroPID entity = assignGv3(event.getGovHydroPIDId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPID(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPID(entity);
  }

  /*
   * @param	event UnAssignGv3FromGovHydroPIDEvent
   */
  @EventHandler(payloadType = UnAssignGv3FromGovHydroPIDEvent.class)
  public void handle(UnAssignGv3FromGovHydroPIDEvent event) {
    LOGGER.info("handling UnAssignGv3FromGovHydroPIDEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroPID entity = unAssignGv3(event.getGovHydroPIDId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPID(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPID(entity);
  }

  /*
   * @param	event AssignGv4ToGovHydroPIDEvent
   */
  @EventHandler(payloadType = AssignGv4ToGovHydroPIDEvent.class)
  public void handle(AssignGv4ToGovHydroPIDEvent event) {
    LOGGER.info("handling AssignGv4ToGovHydroPIDEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroPID entity = assignGv4(event.getGovHydroPIDId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPID(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPID(entity);
  }

  /*
   * @param	event UnAssignGv4FromGovHydroPIDEvent
   */
  @EventHandler(payloadType = UnAssignGv4FromGovHydroPIDEvent.class)
  public void handle(UnAssignGv4FromGovHydroPIDEvent event) {
    LOGGER.info("handling UnAssignGv4FromGovHydroPIDEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroPID entity = unAssignGv4(event.getGovHydroPIDId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPID(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPID(entity);
  }

  /*
   * @param	event AssignGv5ToGovHydroPIDEvent
   */
  @EventHandler(payloadType = AssignGv5ToGovHydroPIDEvent.class)
  public void handle(AssignGv5ToGovHydroPIDEvent event) {
    LOGGER.info("handling AssignGv5ToGovHydroPIDEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroPID entity = assignGv5(event.getGovHydroPIDId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPID(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPID(entity);
  }

  /*
   * @param	event UnAssignGv5FromGovHydroPIDEvent
   */
  @EventHandler(payloadType = UnAssignGv5FromGovHydroPIDEvent.class)
  public void handle(UnAssignGv5FromGovHydroPIDEvent event) {
    LOGGER.info("handling UnAssignGv5FromGovHydroPIDEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroPID entity = unAssignGv5(event.getGovHydroPIDId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPID(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPID(entity);
  }

  /*
   * @param	event AssignGv6ToGovHydroPIDEvent
   */
  @EventHandler(payloadType = AssignGv6ToGovHydroPIDEvent.class)
  public void handle(AssignGv6ToGovHydroPIDEvent event) {
    LOGGER.info("handling AssignGv6ToGovHydroPIDEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroPID entity = assignGv6(event.getGovHydroPIDId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPID(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPID(entity);
  }

  /*
   * @param	event UnAssignGv6FromGovHydroPIDEvent
   */
  @EventHandler(payloadType = UnAssignGv6FromGovHydroPIDEvent.class)
  public void handle(UnAssignGv6FromGovHydroPIDEvent event) {
    LOGGER.info("handling UnAssignGv6FromGovHydroPIDEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroPID entity = unAssignGv6(event.getGovHydroPIDId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPID(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPID(entity);
  }

  /*
   * @param	event AssignInputSignalToGovHydroPIDEvent
   */
  @EventHandler(payloadType = AssignInputSignalToGovHydroPIDEvent.class)
  public void handle(AssignInputSignalToGovHydroPIDEvent event) {
    LOGGER.info("handling AssignInputSignalToGovHydroPIDEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroPID entity = assignInputSignal(event.getGovHydroPIDId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPID(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPID(entity);
  }

  /*
   * @param	event UnAssignInputSignalFromGovHydroPIDEvent
   */
  @EventHandler(payloadType = UnAssignInputSignalFromGovHydroPIDEvent.class)
  public void handle(UnAssignInputSignalFromGovHydroPIDEvent event) {
    LOGGER.info("handling UnAssignInputSignalFromGovHydroPIDEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroPID entity = unAssignInputSignal(event.getGovHydroPIDId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPID(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPID(entity);
  }

  /*
   * @param	event AssignKdToGovHydroPIDEvent
   */
  @EventHandler(payloadType = AssignKdToGovHydroPIDEvent.class)
  public void handle(AssignKdToGovHydroPIDEvent event) {
    LOGGER.info("handling AssignKdToGovHydroPIDEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroPID entity = assignKd(event.getGovHydroPIDId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPID(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPID(entity);
  }

  /*
   * @param	event UnAssignKdFromGovHydroPIDEvent
   */
  @EventHandler(payloadType = UnAssignKdFromGovHydroPIDEvent.class)
  public void handle(UnAssignKdFromGovHydroPIDEvent event) {
    LOGGER.info("handling UnAssignKdFromGovHydroPIDEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroPID entity = unAssignKd(event.getGovHydroPIDId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPID(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPID(entity);
  }

  /*
   * @param	event AssignKgToGovHydroPIDEvent
   */
  @EventHandler(payloadType = AssignKgToGovHydroPIDEvent.class)
  public void handle(AssignKgToGovHydroPIDEvent event) {
    LOGGER.info("handling AssignKgToGovHydroPIDEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroPID entity = assignKg(event.getGovHydroPIDId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPID(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPID(entity);
  }

  /*
   * @param	event UnAssignKgFromGovHydroPIDEvent
   */
  @EventHandler(payloadType = UnAssignKgFromGovHydroPIDEvent.class)
  public void handle(UnAssignKgFromGovHydroPIDEvent event) {
    LOGGER.info("handling UnAssignKgFromGovHydroPIDEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroPID entity = unAssignKg(event.getGovHydroPIDId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPID(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPID(entity);
  }

  /*
   * @param	event AssignKiToGovHydroPIDEvent
   */
  @EventHandler(payloadType = AssignKiToGovHydroPIDEvent.class)
  public void handle(AssignKiToGovHydroPIDEvent event) {
    LOGGER.info("handling AssignKiToGovHydroPIDEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroPID entity = assignKi(event.getGovHydroPIDId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPID(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPID(entity);
  }

  /*
   * @param	event UnAssignKiFromGovHydroPIDEvent
   */
  @EventHandler(payloadType = UnAssignKiFromGovHydroPIDEvent.class)
  public void handle(UnAssignKiFromGovHydroPIDEvent event) {
    LOGGER.info("handling UnAssignKiFromGovHydroPIDEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroPID entity = unAssignKi(event.getGovHydroPIDId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPID(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPID(entity);
  }

  /*
   * @param	event AssignKpToGovHydroPIDEvent
   */
  @EventHandler(payloadType = AssignKpToGovHydroPIDEvent.class)
  public void handle(AssignKpToGovHydroPIDEvent event) {
    LOGGER.info("handling AssignKpToGovHydroPIDEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroPID entity = assignKp(event.getGovHydroPIDId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPID(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPID(entity);
  }

  /*
   * @param	event UnAssignKpFromGovHydroPIDEvent
   */
  @EventHandler(payloadType = UnAssignKpFromGovHydroPIDEvent.class)
  public void handle(UnAssignKpFromGovHydroPIDEvent event) {
    LOGGER.info("handling UnAssignKpFromGovHydroPIDEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroPID entity = unAssignKp(event.getGovHydroPIDId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPID(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPID(entity);
  }

  /*
   * @param	event AssignMwbaseToGovHydroPIDEvent
   */
  @EventHandler(payloadType = AssignMwbaseToGovHydroPIDEvent.class)
  public void handle(AssignMwbaseToGovHydroPIDEvent event) {
    LOGGER.info("handling AssignMwbaseToGovHydroPIDEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroPID entity = assignMwbase(event.getGovHydroPIDId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPID(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPID(entity);
  }

  /*
   * @param	event UnAssignMwbaseFromGovHydroPIDEvent
   */
  @EventHandler(payloadType = UnAssignMwbaseFromGovHydroPIDEvent.class)
  public void handle(UnAssignMwbaseFromGovHydroPIDEvent event) {
    LOGGER.info("handling UnAssignMwbaseFromGovHydroPIDEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroPID entity = unAssignMwbase(event.getGovHydroPIDId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPID(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPID(entity);
  }

  /*
   * @param	event AssignPgv1ToGovHydroPIDEvent
   */
  @EventHandler(payloadType = AssignPgv1ToGovHydroPIDEvent.class)
  public void handle(AssignPgv1ToGovHydroPIDEvent event) {
    LOGGER.info("handling AssignPgv1ToGovHydroPIDEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroPID entity = assignPgv1(event.getGovHydroPIDId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPID(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPID(entity);
  }

  /*
   * @param	event UnAssignPgv1FromGovHydroPIDEvent
   */
  @EventHandler(payloadType = UnAssignPgv1FromGovHydroPIDEvent.class)
  public void handle(UnAssignPgv1FromGovHydroPIDEvent event) {
    LOGGER.info("handling UnAssignPgv1FromGovHydroPIDEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroPID entity = unAssignPgv1(event.getGovHydroPIDId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPID(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPID(entity);
  }

  /*
   * @param	event AssignPgv2ToGovHydroPIDEvent
   */
  @EventHandler(payloadType = AssignPgv2ToGovHydroPIDEvent.class)
  public void handle(AssignPgv2ToGovHydroPIDEvent event) {
    LOGGER.info("handling AssignPgv2ToGovHydroPIDEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroPID entity = assignPgv2(event.getGovHydroPIDId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPID(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPID(entity);
  }

  /*
   * @param	event UnAssignPgv2FromGovHydroPIDEvent
   */
  @EventHandler(payloadType = UnAssignPgv2FromGovHydroPIDEvent.class)
  public void handle(UnAssignPgv2FromGovHydroPIDEvent event) {
    LOGGER.info("handling UnAssignPgv2FromGovHydroPIDEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroPID entity = unAssignPgv2(event.getGovHydroPIDId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPID(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPID(entity);
  }

  /*
   * @param	event AssignPgv3ToGovHydroPIDEvent
   */
  @EventHandler(payloadType = AssignPgv3ToGovHydroPIDEvent.class)
  public void handle(AssignPgv3ToGovHydroPIDEvent event) {
    LOGGER.info("handling AssignPgv3ToGovHydroPIDEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroPID entity = assignPgv3(event.getGovHydroPIDId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPID(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPID(entity);
  }

  /*
   * @param	event UnAssignPgv3FromGovHydroPIDEvent
   */
  @EventHandler(payloadType = UnAssignPgv3FromGovHydroPIDEvent.class)
  public void handle(UnAssignPgv3FromGovHydroPIDEvent event) {
    LOGGER.info("handling UnAssignPgv3FromGovHydroPIDEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroPID entity = unAssignPgv3(event.getGovHydroPIDId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPID(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPID(entity);
  }

  /*
   * @param	event AssignPgv4ToGovHydroPIDEvent
   */
  @EventHandler(payloadType = AssignPgv4ToGovHydroPIDEvent.class)
  public void handle(AssignPgv4ToGovHydroPIDEvent event) {
    LOGGER.info("handling AssignPgv4ToGovHydroPIDEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroPID entity = assignPgv4(event.getGovHydroPIDId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPID(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPID(entity);
  }

  /*
   * @param	event UnAssignPgv4FromGovHydroPIDEvent
   */
  @EventHandler(payloadType = UnAssignPgv4FromGovHydroPIDEvent.class)
  public void handle(UnAssignPgv4FromGovHydroPIDEvent event) {
    LOGGER.info("handling UnAssignPgv4FromGovHydroPIDEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroPID entity = unAssignPgv4(event.getGovHydroPIDId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPID(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPID(entity);
  }

  /*
   * @param	event AssignPgv5ToGovHydroPIDEvent
   */
  @EventHandler(payloadType = AssignPgv5ToGovHydroPIDEvent.class)
  public void handle(AssignPgv5ToGovHydroPIDEvent event) {
    LOGGER.info("handling AssignPgv5ToGovHydroPIDEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroPID entity = assignPgv5(event.getGovHydroPIDId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPID(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPID(entity);
  }

  /*
   * @param	event UnAssignPgv5FromGovHydroPIDEvent
   */
  @EventHandler(payloadType = UnAssignPgv5FromGovHydroPIDEvent.class)
  public void handle(UnAssignPgv5FromGovHydroPIDEvent event) {
    LOGGER.info("handling UnAssignPgv5FromGovHydroPIDEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroPID entity = unAssignPgv5(event.getGovHydroPIDId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPID(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPID(entity);
  }

  /*
   * @param	event AssignPgv6ToGovHydroPIDEvent
   */
  @EventHandler(payloadType = AssignPgv6ToGovHydroPIDEvent.class)
  public void handle(AssignPgv6ToGovHydroPIDEvent event) {
    LOGGER.info("handling AssignPgv6ToGovHydroPIDEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroPID entity = assignPgv6(event.getGovHydroPIDId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPID(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPID(entity);
  }

  /*
   * @param	event UnAssignPgv6FromGovHydroPIDEvent
   */
  @EventHandler(payloadType = UnAssignPgv6FromGovHydroPIDEvent.class)
  public void handle(UnAssignPgv6FromGovHydroPIDEvent event) {
    LOGGER.info("handling UnAssignPgv6FromGovHydroPIDEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroPID entity = unAssignPgv6(event.getGovHydroPIDId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPID(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPID(entity);
  }

  /*
   * @param	event AssignPmaxToGovHydroPIDEvent
   */
  @EventHandler(payloadType = AssignPmaxToGovHydroPIDEvent.class)
  public void handle(AssignPmaxToGovHydroPIDEvent event) {
    LOGGER.info("handling AssignPmaxToGovHydroPIDEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroPID entity = assignPmax(event.getGovHydroPIDId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPID(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPID(entity);
  }

  /*
   * @param	event UnAssignPmaxFromGovHydroPIDEvent
   */
  @EventHandler(payloadType = UnAssignPmaxFromGovHydroPIDEvent.class)
  public void handle(UnAssignPmaxFromGovHydroPIDEvent event) {
    LOGGER.info("handling UnAssignPmaxFromGovHydroPIDEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroPID entity = unAssignPmax(event.getGovHydroPIDId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPID(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPID(entity);
  }

  /*
   * @param	event AssignPminToGovHydroPIDEvent
   */
  @EventHandler(payloadType = AssignPminToGovHydroPIDEvent.class)
  public void handle(AssignPminToGovHydroPIDEvent event) {
    LOGGER.info("handling AssignPminToGovHydroPIDEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroPID entity = assignPmin(event.getGovHydroPIDId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPID(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPID(entity);
  }

  /*
   * @param	event UnAssignPminFromGovHydroPIDEvent
   */
  @EventHandler(payloadType = UnAssignPminFromGovHydroPIDEvent.class)
  public void handle(UnAssignPminFromGovHydroPIDEvent event) {
    LOGGER.info("handling UnAssignPminFromGovHydroPIDEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroPID entity = unAssignPmin(event.getGovHydroPIDId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPID(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPID(entity);
  }

  /*
   * @param	event AssignRToGovHydroPIDEvent
   */
  @EventHandler(payloadType = AssignRToGovHydroPIDEvent.class)
  public void handle(AssignRToGovHydroPIDEvent event) {
    LOGGER.info("handling AssignRToGovHydroPIDEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroPID entity = assignR(event.getGovHydroPIDId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPID(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPID(entity);
  }

  /*
   * @param	event UnAssignRFromGovHydroPIDEvent
   */
  @EventHandler(payloadType = UnAssignRFromGovHydroPIDEvent.class)
  public void handle(UnAssignRFromGovHydroPIDEvent event) {
    LOGGER.info("handling UnAssignRFromGovHydroPIDEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroPID entity = unAssignR(event.getGovHydroPIDId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPID(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPID(entity);
  }

  /*
   * @param	event AssignTdToGovHydroPIDEvent
   */
  @EventHandler(payloadType = AssignTdToGovHydroPIDEvent.class)
  public void handle(AssignTdToGovHydroPIDEvent event) {
    LOGGER.info("handling AssignTdToGovHydroPIDEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroPID entity = assignTd(event.getGovHydroPIDId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPID(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPID(entity);
  }

  /*
   * @param	event UnAssignTdFromGovHydroPIDEvent
   */
  @EventHandler(payloadType = UnAssignTdFromGovHydroPIDEvent.class)
  public void handle(UnAssignTdFromGovHydroPIDEvent event) {
    LOGGER.info("handling UnAssignTdFromGovHydroPIDEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroPID entity = unAssignTd(event.getGovHydroPIDId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPID(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPID(entity);
  }

  /*
   * @param	event AssignTfToGovHydroPIDEvent
   */
  @EventHandler(payloadType = AssignTfToGovHydroPIDEvent.class)
  public void handle(AssignTfToGovHydroPIDEvent event) {
    LOGGER.info("handling AssignTfToGovHydroPIDEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroPID entity = assignTf(event.getGovHydroPIDId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPID(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPID(entity);
  }

  /*
   * @param	event UnAssignTfFromGovHydroPIDEvent
   */
  @EventHandler(payloadType = UnAssignTfFromGovHydroPIDEvent.class)
  public void handle(UnAssignTfFromGovHydroPIDEvent event) {
    LOGGER.info("handling UnAssignTfFromGovHydroPIDEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroPID entity = unAssignTf(event.getGovHydroPIDId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPID(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPID(entity);
  }

  /*
   * @param	event AssignTpToGovHydroPIDEvent
   */
  @EventHandler(payloadType = AssignTpToGovHydroPIDEvent.class)
  public void handle(AssignTpToGovHydroPIDEvent event) {
    LOGGER.info("handling AssignTpToGovHydroPIDEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroPID entity = assignTp(event.getGovHydroPIDId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPID(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPID(entity);
  }

  /*
   * @param	event UnAssignTpFromGovHydroPIDEvent
   */
  @EventHandler(payloadType = UnAssignTpFromGovHydroPIDEvent.class)
  public void handle(UnAssignTpFromGovHydroPIDEvent event) {
    LOGGER.info("handling UnAssignTpFromGovHydroPIDEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroPID entity = unAssignTp(event.getGovHydroPIDId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPID(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPID(entity);
  }

  /*
   * @param	event AssignTtToGovHydroPIDEvent
   */
  @EventHandler(payloadType = AssignTtToGovHydroPIDEvent.class)
  public void handle(AssignTtToGovHydroPIDEvent event) {
    LOGGER.info("handling AssignTtToGovHydroPIDEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroPID entity = assignTt(event.getGovHydroPIDId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPID(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPID(entity);
  }

  /*
   * @param	event UnAssignTtFromGovHydroPIDEvent
   */
  @EventHandler(payloadType = UnAssignTtFromGovHydroPIDEvent.class)
  public void handle(UnAssignTtFromGovHydroPIDEvent event) {
    LOGGER.info("handling UnAssignTtFromGovHydroPIDEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroPID entity = unAssignTt(event.getGovHydroPIDId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPID(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPID(entity);
  }

  /*
   * @param	event AssignTturbToGovHydroPIDEvent
   */
  @EventHandler(payloadType = AssignTturbToGovHydroPIDEvent.class)
  public void handle(AssignTturbToGovHydroPIDEvent event) {
    LOGGER.info("handling AssignTturbToGovHydroPIDEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroPID entity = assignTturb(event.getGovHydroPIDId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPID(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPID(entity);
  }

  /*
   * @param	event UnAssignTturbFromGovHydroPIDEvent
   */
  @EventHandler(payloadType = UnAssignTturbFromGovHydroPIDEvent.class)
  public void handle(UnAssignTturbFromGovHydroPIDEvent event) {
    LOGGER.info("handling UnAssignTturbFromGovHydroPIDEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroPID entity = unAssignTturb(event.getGovHydroPIDId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPID(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPID(entity);
  }

  /*
   * @param	event AssignVelclToGovHydroPIDEvent
   */
  @EventHandler(payloadType = AssignVelclToGovHydroPIDEvent.class)
  public void handle(AssignVelclToGovHydroPIDEvent event) {
    LOGGER.info("handling AssignVelclToGovHydroPIDEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroPID entity = assignVelcl(event.getGovHydroPIDId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPID(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPID(entity);
  }

  /*
   * @param	event UnAssignVelclFromGovHydroPIDEvent
   */
  @EventHandler(payloadType = UnAssignVelclFromGovHydroPIDEvent.class)
  public void handle(UnAssignVelclFromGovHydroPIDEvent event) {
    LOGGER.info("handling UnAssignVelclFromGovHydroPIDEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroPID entity = unAssignVelcl(event.getGovHydroPIDId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPID(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPID(entity);
  }

  /*
   * @param	event AssignVelopToGovHydroPIDEvent
   */
  @EventHandler(payloadType = AssignVelopToGovHydroPIDEvent.class)
  public void handle(AssignVelopToGovHydroPIDEvent event) {
    LOGGER.info("handling AssignVelopToGovHydroPIDEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroPID entity = assignVelop(event.getGovHydroPIDId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPID(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPID(entity);
  }

  /*
   * @param	event UnAssignVelopFromGovHydroPIDEvent
   */
  @EventHandler(payloadType = UnAssignVelopFromGovHydroPIDEvent.class)
  public void handle(UnAssignVelopFromGovHydroPIDEvent event) {
    LOGGER.info("handling UnAssignVelopFromGovHydroPIDEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroPID entity = unAssignVelop(event.getGovHydroPIDId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPID(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPID(entity);
  }

  /**
   * Method to retrieve the GovHydroPID via an GovHydroPIDPrimaryKey.
   *
   * @param id Long
   * @return GovHydroPID
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public GovHydroPID handle(FindGovHydroPIDQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getGovHydroPIDId());
  }

  /**
   * Method to retrieve a collection of all GovHydroPIDs
   *
   * @param query FindAllGovHydroPIDQuery
   * @return List<GovHydroPID>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<GovHydroPID> handle(FindAllGovHydroPIDQuery query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindGovHydroPID, but only if the id matches
   *
   * @param entity GovHydroPID
   */
  protected void emitFindGovHydroPID(GovHydroPID entity) {
    LOGGER.info("handling emitFindGovHydroPID");

    queryUpdateEmitter.emit(
        FindGovHydroPIDQuery.class,
        query -> query.getFilter().getGovHydroPIDId().equals(entity.getGovHydroPIDId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllGovHydroPID
   *
   * @param entity GovHydroPID
   */
  protected void emitFindAllGovHydroPID(GovHydroPID entity) {
    LOGGER.info("handling emitFindAllGovHydroPID");

    queryUpdateEmitter.emit(FindAllGovHydroPIDQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(GovHydroPIDProjector.class.getName());
}
