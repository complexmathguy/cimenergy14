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
package com.occulue.europeanstandards.extension.delegate;

import com.occulue.api.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.extension.validator.*;
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
 * ENTSOEIdentifiedObject business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of ENTSOEIdentifiedObject related services in the case of a
 *       ENTSOEIdentifiedObject business related service failing.
 *   <li>Exposes a simpler, uniform ENTSOEIdentifiedObject interface to the business tier, making it
 *       easy for clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill ENTSOEIdentifiedObject
 *       business related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class ENTSOEIdentifiedObjectBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public ENTSOEIdentifiedObjectBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * ENTSOEIdentifiedObject Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return ENTSOEIdentifiedObjectBusinessDelegate
   */
  public static ENTSOEIdentifiedObjectBusinessDelegate getENTSOEIdentifiedObjectInstance() {
    return (new ENTSOEIdentifiedObjectBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createENTSOEIdentifiedObject(
      CreateENTSOEIdentifiedObjectCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getENTSOEIdentifiedObjectId() == null)
        command.setENTSOEIdentifiedObjectId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      ENTSOEIdentifiedObjectValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateENTSOEIdentifiedObjectCommand - by convention the future return value for a
      // create command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateENTSOEIdentifiedObjectCommand of ENTSOEIdentifiedObject is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create ENTSOEIdentifiedObject - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateENTSOEIdentifiedObjectCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateENTSOEIdentifiedObject(
      UpdateENTSOEIdentifiedObjectCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      ENTSOEIdentifiedObjectValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateENTSOEIdentifiedObjectCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save ENTSOEIdentifiedObject - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteENTSOEIdentifiedObjectCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteENTSOEIdentifiedObjectCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ENTSOEIdentifiedObjectValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteENTSOEIdentifiedObjectCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete ENTSOEIdentifiedObject using Id = "
              + command.getENTSOEIdentifiedObjectId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the ENTSOEIdentifiedObject via ENTSOEIdentifiedObjectFetchOneSummary
   *
   * @param summary ENTSOEIdentifiedObjectFetchOneSummary
   * @return ENTSOEIdentifiedObjectFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public ENTSOEIdentifiedObject getENTSOEIdentifiedObject(
      ENTSOEIdentifiedObjectFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException(
          "ENTSOEIdentifiedObjectFetchOneSummary arg cannot be null");

    ENTSOEIdentifiedObject entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      ENTSOEIdentifiedObjectValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a ENTSOEIdentifiedObject
      // --------------------------------------
      CompletableFuture<ENTSOEIdentifiedObject> futureEntity =
          queryGateway.query(
              new FindENTSOEIdentifiedObjectQuery(
                  new LoadENTSOEIdentifiedObjectFilter(summary.getENTSOEIdentifiedObjectId())),
              ResponseTypes.instanceOf(ENTSOEIdentifiedObject.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg =
          "Unable to locate ENTSOEIdentifiedObject with id "
              + summary.getENTSOEIdentifiedObjectId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all ENTSOEIdentifiedObjects
   *
   * @return List<ENTSOEIdentifiedObject>
   * @exception ProcessingException Thrown if any problems
   */
  public List<ENTSOEIdentifiedObject> getAllENTSOEIdentifiedObject() throws ProcessingException {
    List<ENTSOEIdentifiedObject> list = null;

    try {
      CompletableFuture<List<ENTSOEIdentifiedObject>> futureList =
          queryGateway.query(
              new FindAllENTSOEIdentifiedObjectQuery(),
              ResponseTypes.multipleInstancesOf(ENTSOEIdentifiedObject.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all ENTSOEIdentifiedObject";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign EnergyIdentCodeEic on ENTSOEIdentifiedObject
   *
   * @param command AssignEnergyIdentCodeEicToENTSOEIdentifiedObjectCommand
   * @exception ProcessingException
   */
  public void assignEnergyIdentCodeEic(
      AssignEnergyIdentCodeEicToENTSOEIdentifiedObjectCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getENTSOEIdentifiedObjectId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .StringProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .StringProxyBusinessDelegate.getStringProxyInstance();
    ENTSOEIdentifiedObjectBusinessDelegate parentDelegate =
        ENTSOEIdentifiedObjectBusinessDelegate.getENTSOEIdentifiedObjectInstance();
    UUID childId = command.getAssignment().getStringProxyId();
    StringProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ENTSOEIdentifiedObjectValidator.getInstance().validate(command);

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
   * unAssign EnergyIdentCodeEic on ENTSOEIdentifiedObject
   *
   * @param command UnAssignEnergyIdentCodeEicFromENTSOEIdentifiedObjectCommand
   * @exception ProcessingException
   */
  public void unAssignEnergyIdentCodeEic(
      UnAssignEnergyIdentCodeEicFromENTSOEIdentifiedObjectCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ENTSOEIdentifiedObjectValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign EnergyIdentCodeEic on ENTSOEIdentifiedObject";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign ShortName on ENTSOEIdentifiedObject
   *
   * @param command AssignShortNameToENTSOEIdentifiedObjectCommand
   * @exception ProcessingException
   */
  public void assignShortName(AssignShortNameToENTSOEIdentifiedObjectCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getENTSOEIdentifiedObjectId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .StringProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .StringProxyBusinessDelegate.getStringProxyInstance();
    ENTSOEIdentifiedObjectBusinessDelegate parentDelegate =
        ENTSOEIdentifiedObjectBusinessDelegate.getENTSOEIdentifiedObjectInstance();
    UUID childId = command.getAssignment().getStringProxyId();
    StringProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ENTSOEIdentifiedObjectValidator.getInstance().validate(command);

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
   * unAssign ShortName on ENTSOEIdentifiedObject
   *
   * @param command UnAssignShortNameFromENTSOEIdentifiedObjectCommand
   * @exception ProcessingException
   */
  public void unAssignShortName(UnAssignShortNameFromENTSOEIdentifiedObjectCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ENTSOEIdentifiedObjectValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign ShortName on ENTSOEIdentifiedObject";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return ENTSOEIdentifiedObject
   */
  private ENTSOEIdentifiedObject load(UUID id) throws ProcessingException {
    eNTSOEIdentifiedObject =
        ENTSOEIdentifiedObjectBusinessDelegate.getENTSOEIdentifiedObjectInstance()
            .getENTSOEIdentifiedObject(new ENTSOEIdentifiedObjectFetchOneSummary(id));
    return eNTSOEIdentifiedObject;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private ENTSOEIdentifiedObject eNTSOEIdentifiedObject = null;
  private static final Logger LOGGER =
      Logger.getLogger(ENTSOEIdentifiedObjectBusinessDelegate.class.getName());
}
