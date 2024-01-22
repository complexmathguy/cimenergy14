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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentboundaryprofile.core.delegate;

import com.occulue.api.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentboundaryprofile.core.validator.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.queryhandling.QueryUpdateEmitter;

/**
 * IdentifiedObject business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of IdentifiedObject related services in the case of a
 *       IdentifiedObject business related service failing.
 *   <li>Exposes a simpler, uniform IdentifiedObject interface to the business tier, making it easy
 *       for clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill IdentifiedObject business
 *       related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class IdentifiedObjectBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public IdentifiedObjectBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * IdentifiedObject Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return IdentifiedObjectBusinessDelegate
   */
  public static IdentifiedObjectBusinessDelegate getIdentifiedObjectInstance() {
    return (new IdentifiedObjectBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createIdentifiedObject(CreateIdentifiedObjectCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getIdentifiedObjectId() == null) command.setIdentifiedObjectId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      IdentifiedObjectValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateIdentifiedObjectCommand - by convention the future return value for a
      // create command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateIdentifiedObjectCommand of IdentifiedObject is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create IdentifiedObject - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateIdentifiedObjectCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateIdentifiedObject(UpdateIdentifiedObjectCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      IdentifiedObjectValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateIdentifiedObjectCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save IdentifiedObject - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteIdentifiedObjectCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteIdentifiedObjectCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      IdentifiedObjectValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteIdentifiedObjectCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete IdentifiedObject using Id = " + command.getIdentifiedObjectId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the IdentifiedObject via IdentifiedObjectFetchOneSummary
   *
   * @param summary IdentifiedObjectFetchOneSummary
   * @return IdentifiedObjectFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public IdentifiedObject getIdentifiedObject(IdentifiedObjectFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("IdentifiedObjectFetchOneSummary arg cannot be null");

    IdentifiedObject entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      IdentifiedObjectValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a IdentifiedObject
      // --------------------------------------
      CompletableFuture<IdentifiedObject> futureEntity =
          queryGateway.query(
              new FindIdentifiedObjectQuery(
                  new LoadIdentifiedObjectFilter(summary.getIdentifiedObjectId())),
              ResponseTypes.instanceOf(IdentifiedObject.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg =
          "Unable to locate IdentifiedObject with id " + summary.getIdentifiedObjectId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all IdentifiedObjects
   *
   * @return List<IdentifiedObject>
   * @exception ProcessingException Thrown if any problems
   */
  public List<IdentifiedObject> getAllIdentifiedObject() throws ProcessingException {
    List<IdentifiedObject> list = null;

    try {
      CompletableFuture<List<IdentifiedObject>> futureList =
          queryGateway.query(
              new FindAllIdentifiedObjectQuery(),
              ResponseTypes.multipleInstancesOf(IdentifiedObject.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all IdentifiedObject";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign Description on IdentifiedObject
   *
   * @param command AssignDescriptionToIdentifiedObjectCommand
   * @exception ProcessingException
   */
  public void assignDescription(AssignDescriptionToIdentifiedObjectCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getIdentifiedObjectId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .StringProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .StringProxyBusinessDelegate.getStringProxyInstance();
    IdentifiedObjectBusinessDelegate parentDelegate =
        IdentifiedObjectBusinessDelegate.getIdentifiedObjectInstance();
    UUID childId = command.getAssignment().getStringProxyId();
    StringProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      IdentifiedObjectValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get StringProxy using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Description on IdentifiedObject
   *
   * @param command UnAssignDescriptionFromIdentifiedObjectCommand
   * @exception ProcessingException
   */
  public void unAssignDescription(UnAssignDescriptionFromIdentifiedObjectCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      IdentifiedObjectValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Description on IdentifiedObject";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign EnergyIdentCodeEic on IdentifiedObject
   *
   * @param command AssignEnergyIdentCodeEicToIdentifiedObjectCommand
   * @exception ProcessingException
   */
  public void assignEnergyIdentCodeEic(AssignEnergyIdentCodeEicToIdentifiedObjectCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getIdentifiedObjectId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .StringProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .StringProxyBusinessDelegate.getStringProxyInstance();
    IdentifiedObjectBusinessDelegate parentDelegate =
        IdentifiedObjectBusinessDelegate.getIdentifiedObjectInstance();
    UUID childId = command.getAssignment().getStringProxyId();
    StringProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      IdentifiedObjectValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get StringProxy using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign EnergyIdentCodeEic on IdentifiedObject
   *
   * @param command UnAssignEnergyIdentCodeEicFromIdentifiedObjectCommand
   * @exception ProcessingException
   */
  public void unAssignEnergyIdentCodeEic(
      UnAssignEnergyIdentCodeEicFromIdentifiedObjectCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      IdentifiedObjectValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign EnergyIdentCodeEic on IdentifiedObject";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign MRID on IdentifiedObject
   *
   * @param command AssignMRIDToIdentifiedObjectCommand
   * @exception ProcessingException
   */
  public void assignMRID(AssignMRIDToIdentifiedObjectCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getIdentifiedObjectId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .StringProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .StringProxyBusinessDelegate.getStringProxyInstance();
    IdentifiedObjectBusinessDelegate parentDelegate =
        IdentifiedObjectBusinessDelegate.getIdentifiedObjectInstance();
    UUID childId = command.getAssignment().getStringProxyId();
    StringProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      IdentifiedObjectValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get StringProxy using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign MRID on IdentifiedObject
   *
   * @param command UnAssignMRIDFromIdentifiedObjectCommand
   * @exception ProcessingException
   */
  public void unAssignMRID(UnAssignMRIDFromIdentifiedObjectCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      IdentifiedObjectValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign MRID on IdentifiedObject";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Name on IdentifiedObject
   *
   * @param command AssignNameToIdentifiedObjectCommand
   * @exception ProcessingException
   */
  public void assignName(AssignNameToIdentifiedObjectCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getIdentifiedObjectId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .StringProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .StringProxyBusinessDelegate.getStringProxyInstance();
    IdentifiedObjectBusinessDelegate parentDelegate =
        IdentifiedObjectBusinessDelegate.getIdentifiedObjectInstance();
    UUID childId = command.getAssignment().getStringProxyId();
    StringProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      IdentifiedObjectValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get StringProxy using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Name on IdentifiedObject
   *
   * @param command UnAssignNameFromIdentifiedObjectCommand
   * @exception ProcessingException
   */
  public void unAssignName(UnAssignNameFromIdentifiedObjectCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      IdentifiedObjectValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Name on IdentifiedObject";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign ShortName on IdentifiedObject
   *
   * @param command AssignShortNameToIdentifiedObjectCommand
   * @exception ProcessingException
   */
  public void assignShortName(AssignShortNameToIdentifiedObjectCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getIdentifiedObjectId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .StringProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .StringProxyBusinessDelegate.getStringProxyInstance();
    IdentifiedObjectBusinessDelegate parentDelegate =
        IdentifiedObjectBusinessDelegate.getIdentifiedObjectInstance();
    UUID childId = command.getAssignment().getStringProxyId();
    StringProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      IdentifiedObjectValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get StringProxy using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign ShortName on IdentifiedObject
   *
   * @param command UnAssignShortNameFromIdentifiedObjectCommand
   * @exception ProcessingException
   */
  public void unAssignShortName(UnAssignShortNameFromIdentifiedObjectCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      IdentifiedObjectValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign ShortName on IdentifiedObject";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return IdentifiedObject
   */
  private IdentifiedObject load(UUID id) throws ProcessingException {
    identifiedObject =
        IdentifiedObjectBusinessDelegate.getIdentifiedObjectInstance()
            .getIdentifiedObject(new IdentifiedObjectFetchOneSummary(id));
    return identifiedObject;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private IdentifiedObject identifiedObject = null;
  private static final Logger LOGGER =
      Logger.getLogger(IdentifiedObjectBusinessDelegate.class.getName());
}
